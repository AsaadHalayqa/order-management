package com.bzu.assignment2.dto;

import com.bzu.assignment2.entity.Order;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Api(value = "Customer model information")
@Data
public class CustomerDto {

    @ApiModelProperty(value = "Customer id")
    private Long customer_id;

    @ApiModelProperty(value = "Customer first name")
    private String firstName;

    @ApiModelProperty(value = "Customer last name")
    private String lastName;

    @ApiModelProperty(value = "Customer email")
    private String email;

    @ApiModelProperty(value = "Customer password")
    private String password;

    @ApiModelProperty(value = "Customer born at")
    private String bornAt;

    /*
    *
    * */

    public CustomerDto() {
    }

    public CustomerDto(Long customer_id, String firstName, String lastName, String email, String password, String bornAt, Set<Order> orders) {
        this.customer_id = customer_id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.bornAt = bornAt;
    }

    public Long getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(Long customer_id) {
        this.customer_id = customer_id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getBornAt() {
        return bornAt;
    }

    public void setBornAt(String bornAt) {
        this.bornAt = bornAt;
    }

}
