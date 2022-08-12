package com.example.MaskingAPIDemo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.UUID;

@Entity
@Table
@Getter
@Setter
public class UserData {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column
    private String id;

    @Column
    @NotBlank(message="Required First Name")
    //@Max(20)
    @Size(max = 20)
    @Pattern(regexp="^[A-Za-z]*$",message = "Invalid First Name")
    private  String firstName;
    @Column
    @NotBlank(message="Required Last Name")
    //@Max(20)
    @Size(max = 20)
    @Pattern(regexp="^[A-Za-z]*$",message = "Invalid Last Name")
    private  String lastName;
    @Column
    //@Max(1)
    @Size(max = 1)
    @Pattern(regexp="^[A-Za-z]*$",message = "Invalid middle Initial")
    private  String middleInitial;
    @Column
    @NotBlank(message="Required Email")
    // @Max(50)
    @Size(max = 50)
    private  String email;
    @Column
    @NotNull(message="Required Phone number")
    @Size(max = 10)
    @Digits(message="It should only have 10 digits",fraction=0,integer=10)
    private  String phoneNumber;
    @Column
    @NotBlank(message="Required Billing Address")
    private  String billingAddress;
    @Column
    private  String shippingAddress;

    public UserData(String id,String firstName, String lastName, String middleInitial, String email, String phoneNumber, String billingAddress, String shippingAddress) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleInitial = middleInitial;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.billingAddress = billingAddress;
        this.shippingAddress = shippingAddress;
    }

    public UserData() {

    }

    public UserData(String id) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleInitial = middleInitial;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.billingAddress = billingAddress;
        this.shippingAddress = shippingAddress;
    }



    }
