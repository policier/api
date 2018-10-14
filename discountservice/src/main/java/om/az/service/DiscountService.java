package om.az.service;

import om.az.api.model.Discount;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class DiscountService {
    private Map <Long, Discount> discountMap = new HashMap ();

    public Discount getDiscount(Long id) {
        return discountMap.get(id);
    }

    public Discount addDiscount(Discount discount){
        discountMap.put(discount.getId(), discount);
        return discount;
    }
}
