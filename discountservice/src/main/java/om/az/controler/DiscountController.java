package om.az.controler;

import io.swagger.annotations.ApiParam;
import om.az.api.DiscountApi;
import om.az.api.model.Discount;
import om.az.service.DiscountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-07-18T15:26:19.614+02:00")

@Controller
public class DiscountController implements DiscountApi {

    @Autowired
    private DiscountService discountService;


    @Override
    public ResponseEntity<Discount> getDiscount(@ApiParam(value = "Application id",required=true) @PathVariable("productId") Long productId)   {
        log.info("DiscountController:getDiscount:productid " + productId);
        return new ResponseEntity<>(discountService.getDiscount(productId), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Discount> addDiscount(@ApiParam(value = "discount to add to the store" , required=true )
    @Valid @RequestBody Discount discount) {
    	System.out.println("Sharing peekings check Dev 1 ");
        Discount addDiscount = discountService.addDiscount(discount);
        return new ResponseEntity<>(addDiscount, HttpStatus.OK);
    }
}
