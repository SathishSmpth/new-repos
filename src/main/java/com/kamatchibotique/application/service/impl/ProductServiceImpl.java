package com.kamatchibotique.application.service.impl;

import com.kamatchibotique.application.constants.AppConstant;
import com.kamatchibotique.application.dto.mapper.product.ProductMapper;
import com.kamatchibotique.application.dto.request.product.ProductDto;
import com.kamatchibotique.application.entity.ManufacturerEntity;
import com.kamatchibotique.application.entity.MerchantStoreEntity;
import com.kamatchibotique.application.entity.product.ProductEntity;
import com.kamatchibotique.application.exception.ServiceException;
import com.kamatchibotique.application.repository.ManufacturerRepository;
import com.kamatchibotique.application.repository.MerchantRepository;
import com.kamatchibotique.application.repository.ProductRepository;
import com.kamatchibotique.application.service.AuthService;
import com.kamatchibotique.application.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;
    private ManufacturerRepository manufacturerRepository;
    private MerchantRepository merchantRepository;
    private AuthService authService;
    private ProductMapper productMapper;

    @Override
    public ProductDto createProduct(ProductDto product) {

        ManufacturerEntity manufacturer = manufacturerRepository.findById(product.getManufacturer().getId()).orElseThrow(() -> new ServiceException(HttpStatus.NOT_FOUND, "Manufacturer was not found given id !."));

        MerchantStoreEntity merchantStore = merchantRepository.findById(product.getMerchantStore().getId()).orElseThrow(() -> new ServiceException(HttpStatus.NOT_FOUND, "Merchant was not found given id !."));

        product.setCreatedBy(authService.getAuthenticatedUsername());

        ProductEntity newProduct = productRepository.save(productMapper.convertToEntity(product));

        List<ProductEntity> merchantProducts = merchantStore.getProducts();
        List<ProductEntity> manufacturerProducts = manufacturer.getProducts();

        merchantProducts.add(newProduct);
        manufacturerProducts.add(newProduct);

        merchantStore.setProducts(merchantProducts);
        manufacturer.setProducts(manufacturerProducts);

        merchantRepository.save(merchantStore);
        manufacturerRepository.save(manufacturer);

        return productMapper.convertToDto(newProduct);
    }

    @Override
    public List<ProductDto> getProductList() {

        List<ProductEntity> listOfTheProducts = productRepository.findAll();

        return listOfTheProducts.stream().map((product) -> productMapper.convertToDto(product)).collect(Collectors.toList());
    }

    @Override
    public ProductDto getProductById(long id) {
        ProductEntity product = productRepository.findById(id).orElseThrow(() -> new ServiceException(HttpStatus.NOT_FOUND, "Product was not found given id!."));

        return productMapper.convertToDto(product);
    }

    @Override
    public ProductDto updateProduct(long id, ProductDto productDto) {
        ProductEntity product = productRepository.findById(id).orElseThrow(() -> new ServiceException(HttpStatus.NOT_FOUND, "Product was not found given id!."));
        ProductEntity updatedProduct = productMapper.convertUpdateRequestToEntity(productDto, product);
        return productMapper.convertToDto(productRepository.save(updatedProduct));
    }

    @Override
    public void deleteProduct(long id) {
        ProductEntity product = productRepository.findById(id).orElseThrow(() -> new ServiceException(HttpStatus.NOT_FOUND, "Product was not found given id!."));
        productRepository.delete(product);
    }

    @Override
    public String generateProductUid(Long id) {
        return String.format("%s%06d", AppConstant.PREFIX, AppConstant.ID_LENGTH);
    }

}
