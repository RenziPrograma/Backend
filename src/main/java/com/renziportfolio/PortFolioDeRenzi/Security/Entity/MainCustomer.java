/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.renziportfolio.PortFolioDeRenzi.Security.Entity;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 *
 * @author redac
 */
public class MainCustomer implements UserDetails {

    private String name;
    private String customerName;
    private String email;
    private String password;
    private Collection<? extends GrantedAuthority> authorities;

    /////////* CONSTRUCTOR**********//
    public MainCustomer(String name, String customerName, String email, String password, Collection<? extends GrantedAuthority> authorities) {
        this.name = name;
        this.customerName = customerName;
        this.email = email;
        this.password = password;
        this.authorities = authorities;
    }

    public static MainCustomer build(Customer customer) {

        List<GrantedAuthority> authorities = customer.getRolls().stream()
                .map(roll -> new SimpleGrantedAuthority(roll.getRollName().name())).collect(Collectors.toList());
        return new MainCustomer(customer.getName(), customer.getCustomerName(), customer.getEmail(), customer.getPassword(), authorities);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String getUsername() {
        return customerName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

}
