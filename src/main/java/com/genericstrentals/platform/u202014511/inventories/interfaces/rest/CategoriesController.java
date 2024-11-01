package com.genericstrentals.platform.u202014511.inventories.interfaces.rest;

import com.genericstrentals.platform.u202014511.inventories.domain.model.aggregates.Category;
import com.genericstrentals.platform.u202014511.inventories.domain.services.CategoryCommandService;
import com.genericstrentals.platform.u202014511.inventories.interfaces.rest.resources.CategoryResource;
import com.genericstrentals.platform.u202014511.inventories.interfaces.rest.resources.CreateCategoryResource;
import com.genericstrentals.platform.u202014511.inventories.interfaces.rest.transform.CategoryResourceFromEntityAssembler;
import com.genericstrentals.platform.u202014511.inventories.interfaces.rest.transform.CreateCategoryCommandFromResourceAssembler;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/api/v1/categories", produces = APPLICATION_JSON_VALUE)
@Tag(name = "Categories", description = "Categories API")
public class CategoriesController {
    private final CategoryCommandService categoryCommandService;

    public CategoriesController(CategoryCommandService categoryCommandService) {
        this.categoryCommandService = categoryCommandService;
    }

    @Operation(
            summary = "Create a new category",
            description = "Crate a new category with the give data"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Category created successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid data"),
    })
    @PostMapping
    public ResponseEntity<CategoryResource> createCategory(@RequestBody CreateCategoryResource resource) {
        Optional<Category> category = this.categoryCommandService
                .handle(CreateCategoryCommandFromResourceAssembler.toCommandFromResource(resource));

        return category.map(source ->
                new ResponseEntity<>(CategoryResourceFromEntityAssembler.toResourceFromEntity(source),
                        HttpStatus.CREATED))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }
}
