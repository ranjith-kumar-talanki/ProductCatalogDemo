package com.example.productcatalogdemo.clients;

import com.example.productcatalogdemo.dtos.FakeStoreProductDTO;
import com.example.productcatalogdemo.models.Product;
import com.example.productcatalogdemo.utils.FakeStoreProductUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.ResponseExtractor;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class FakeStoreProductsAPIClient {


    private final RestTemplate restTemplate;
    private final String fakeStoreProductsAPIUri = "https://fakestoreapi.com/products/";
    private final String productPathVariable = "{id}";

    @Autowired
    private FakeStoreProductsAPIClient(RestTemplateBuilder restTemplateBuilder) {

        restTemplate = restTemplateBuilder.build();
    }

    public List<Product> fetchAllProducts() {
        ResponseEntity<FakeStoreProductDTO[]> responseEntity = restTemplate.getForEntity(fakeStoreProductsAPIUri, FakeStoreProductDTO[].class);
        if (responseEntity.getStatusCode().equals(HttpStatus.OK) && responseEntity.getBody() != null) {
            FakeStoreProductDTO[] response = responseEntity.getBody();
            return Arrays.stream(response).map(FakeStoreProductUtils::mapper).collect(Collectors.toList());
        }
        return new ArrayList<>();
    }

    public Product getProductById(Long id) {
        ResponseEntity<FakeStoreProductDTO> responseEntity = restTemplate.getForEntity(fakeStoreProductsAPIUri+productPathVariable, FakeStoreProductDTO.class, id);
        if (responseEntity.getStatusCode().equals(HttpStatus.OK) && responseEntity.getBody() != null) {
            return FakeStoreProductUtils.mapper(responseEntity.getBody());
        }
        return null;
    }

    public Product createProduct(Product product) {
        ResponseEntity<FakeStoreProductDTO> postResponseEntity = restTemplate.postForEntity(fakeStoreProductsAPIUri, FakeStoreProductUtils.mapToFakeStoreProductDTO(product), FakeStoreProductDTO.class);
        if (postResponseEntity.getStatusCode().equals(HttpStatus.OK) && postResponseEntity.getBody() != null) {
            return FakeStoreProductUtils.mapper(postResponseEntity.getBody());
        }
        return null;
    }

    public Product updateProduct(long productId, Product product) {
        ResponseEntity<FakeStoreProductDTO> putResponse = putForEntity(fakeStoreProductsAPIUri+productPathVariable, FakeStoreProductUtils.mapToFakeStoreProductDTO(product), FakeStoreProductDTO.class, productId);
        if (putResponse.getStatusCode().equals(HttpStatus.OK) && putResponse.getBody() != null) {
            return FakeStoreProductUtils.mapper(putResponse.getBody());
        }
        return null;
    }

    public List<Product> fetchAllProductsByCategory(String category) {
        String categoryPathVariable = "category/{category}";
        ResponseEntity<FakeStoreProductDTO[]> responseEntity = restTemplate.getForEntity(fakeStoreProductsAPIUri+categoryPathVariable, FakeStoreProductDTO[].class, category);
        if (responseEntity.getStatusCode().equals(HttpStatus.OK) && responseEntity.getBody() != null) {
            FakeStoreProductDTO[] response = responseEntity.getBody();
            return Arrays.stream(response).map(FakeStoreProductUtils::mapper).collect(Collectors.toList());
        }
        return new ArrayList<>();
    }

    private <T> ResponseEntity<T> putForEntity(String url, @Nullable Object request, Class<T> responseType, Object... uriVariables) throws RestClientException {
        RequestCallback requestCallback = restTemplate.httpEntityCallback(request, responseType);
        ResponseExtractor<ResponseEntity<T>> responseExtractor = restTemplate.responseEntityExtractor(responseType);
        return restTemplate.execute(url, HttpMethod.PUT, requestCallback, responseExtractor, uriVariables);
    }
}
