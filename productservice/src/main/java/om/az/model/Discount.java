package om.az.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;

import java.util.Objects;

/**
 * The Response that may contain different variations of the telex to get displayed at the frontend
 */
@ApiModel(description = "The Response that may contain different variations of the telex to get displayed at the frontend")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-08-31T15:13:18.990+02:00")

public class Discount {
  @JsonProperty("name")
  private Integer name = null;

  @JsonProperty("price")
  private Integer price = null;

  @JsonProperty("amount")
  private Integer amount = null;

  public Discount name(Integer name) {
    this.name = name;
    return this;
  }

  /**
   * productId
   * @return name
  **/
  @ApiModelProperty(example = "productID", value = "productId")


  public Integer getName() {
    return name;
  }

  public void setName(Integer name) {
    this.name = name;
  }

  public Discount price(Integer price) {
    this.price = price;
    return this;
  }

  /**
   * price
   * @return price
  **/
  @ApiModelProperty(example = "price", value = "price")


  public Integer getPrice() {
    return price;
  }

  public void setPrice(Integer price) {
    this.price = price;
  }

  public Discount amount(Integer amount) {
    this.amount = amount;
    return this;
  }

  /**
   * amount
   * @return amount
  **/
  @ApiModelProperty(example = "amount", value = "amount")


  public Integer getAmount() {
    return amount;
  }

  public void setAmount(Integer amount) {
    this.amount = amount;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Discount discount = (Discount) o;
    return Objects.equals(this.name, discount.name) &&
        Objects.equals(this.price, discount.price) &&
        Objects.equals(this.amount, discount.amount);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, price, amount);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Discount {\n");

    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    price: ").append(toIndentedString(price)).append("\n");
    sb.append("    amount: ").append(toIndentedString(amount)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

