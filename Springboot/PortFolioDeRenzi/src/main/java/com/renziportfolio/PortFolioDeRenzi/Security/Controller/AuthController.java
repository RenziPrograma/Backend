/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.renziportfolio.PortFolioDeRenzi.Security.Controller;

import com.renziportfolio.PortFolioDeRenzi.Security.Dto.CustomerLogin;
import com.renziportfolio.PortFolioDeRenzi.Security.Dto.JwtDto;
import com.renziportfolio.PortFolioDeRenzi.Security.Dto.NewCustomer;



import com.renziportfolio.PortFolioDeRenzi.Security.Entity.Roll;
import com.renziportfolio.PortFolioDeRenzi.Security.Entity.Customer;
import com.renziportfolio.PortFolioDeRenzi.Security.Enums.RollName;
import com.renziportfolio.PortFolioDeRenzi.Security.Service.RollService;
import com.renziportfolio.PortFolioDeRenzi.Security.jwt.JwtProvider;
import com.renziportfolio.PortFolioDeRenzi.Security.Service.CustomerService;
import java.util.HashSet;
import java.util.Set;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author redac
 */

@RestController
@RequestMapping("/auth")
@CrossOrigin
public class AuthController {
    @Autowired
    PasswordEncoder  passwordEncoder;
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    CustomerService customerService;
    @Autowired
    RollService rollService;
    @Autowired
    JwtProvider jwtProvider;
    
    
    @PostMapping("/new")
    public ResponseEntity<?> nuevo (@Valid @RequestBody NewCustomer newCustomer, BindingResult bindingResult){
        if (bindingResult.hasErrors())
            return new ResponseEntity(new Msj("Error, Campos mal puestos o email invalido"),HttpStatus.BAD_REQUEST);
        
        if (customerService.existsByCustomerName(newCustomer.getCustomerName()))
            return new ResponseEntity(new Msj("Error, ese nombre de usuario ya existe"),HttpStatus.BAD_REQUEST); 
        
        if (customerService.existsByEmail(newCustomer.getEmail()))
            return new ResponseEntity(new Msj("Error, este email  ya esta registrado"),HttpStatus.BAD_REQUEST); 
        
        Customer customer= new Customer (newCustomer.getName(), newCustomer.getCustomerName(), newCustomer.getEmail(),
                passwordEncoder.encode(newCustomer.getPassword()));
        
        Set<Roll> rolls =new HashSet<>();
        rolls.add(rollService.getByRollName(RollName.ROLE_USER).get());
        
        if(newCustomer.getRolls().contains("admin"))
            rolls.add(rollService.getByRollName(RollName.ROLE_ADMIN).get());
        customer.setRolls(rolls);
        customerService.save(customer);
        return new ResponseEntity(new Msj("Usuario guardado con éxito!"),HttpStatus.CREATED);  
    }
    
    
    @PostMapping("/login")
    public ResponseEntity <JwtDto> login(@Valid @RequestBody CustomerLogin customerLogin, BindingResult bindingResult){
        if (bindingResult.hasErrors())
            return new ResponseEntity(new Msj("Error, los campos son invalidos"),HttpStatus.BAD_REQUEST);
        
        Authentication authentication=authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(customerLogin.getCustomerName(),customerLogin.getPassword()));
       
        
        SecurityContextHolder.getContext().setAuthentication(authentication);
        
        String jwt= jwtProvider.generateToken(authentication);
        
        UserDetails userDetails=(UserDetails) authentication.getPrincipal();
        
        JwtDto jwtDto= new JwtDto (jwt, userDetails.getUsername(), userDetails.getAuthorities());
        
        return new ResponseEntity(jwtDto,HttpStatus.OK);
    }
}
