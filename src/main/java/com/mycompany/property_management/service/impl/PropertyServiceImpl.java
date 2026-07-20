package com.mycompany.property_management.service.impl;

import com.mycompany.property_management.converter.PropertyConverter;
import com.mycompany.property_management.dto.PropertyDTO;
import com.mycompany.property_management.entity.PropertyEntity;
import com.mycompany.property_management.repository.PropertyRepository;
import com.mycompany.property_management.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class PropertyServiceImpl implements PropertyService {
    @Value("${pms.dummy}")
    private String dummy;

    @Value("${spring.datasource.url}")
    private String dburl;

    @Autowired
    private PropertyRepository propertyRepository;

        @Autowired
    private PropertyConverter propertyConverter;

    @Override
    public PropertyDTO saveProperty(PropertyDTO propertyDTO) {



       PropertyEntity pe = propertyConverter.convertDTOtoEntity(propertyDTO);

      pe = propertyRepository.save(pe);

propertyDTO  =propertyConverter.convertEntityTODTO(pe);

        return propertyDTO;

    }

    @Override
    public List<PropertyDTO> getAllProperties() {


        System.out.println(" inside service ");
        System.out.println(dummy);
        System.out.println(dburl);



        List<PropertyEntity> listofprops =( List<PropertyEntity> ) propertyRepository.findAll();

        List<PropertyDTO> propList=new ArrayList<>();

        for (PropertyEntity pe:listofprops){
           PropertyDTO dto = propertyConverter.convertEntityTODTO(pe);
           propList.add(dto);

        }





        return propList;
    }

    @Override
    public PropertyDTO updateProperty(PropertyDTO propertyDTO, Long propertyId) {

       Optional<PropertyEntity> option= propertyRepository.findById(propertyId);

       PropertyDTO dto=null;

       if(option.isPresent()){
           PropertyEntity pe =option.get();


           pe.setTitle(propertyDTO.getTitle());
           pe.setDescription(propertyDTO.getDescription());
           pe.setAddress(propertyDTO.getAddress());
           pe.setOwnerName(propertyDTO.getOwnerName());               //Our DTO Giving objects But our repository Taking entities. So we have to convert it. this convertion we do is called ADAPTER DESIGN PATTERN
           pe.setOwnerEmail(propertyDTO.getOwnerEmail());
           pe.setPrice(propertyDTO.getPrice());

           dto=propertyConverter.convertEntityTODTO(pe);


           propertyRepository.save(pe);

       }
       return dto;
    }

    @Override
    public PropertyDTO updatePropertyDescription(PropertyDTO propertyDTO, Long propertyId) {
        Optional<PropertyEntity> option= propertyRepository.findById(propertyId);

        PropertyDTO dto=null;

        if(option.isPresent()){
            PropertyEntity pe =option.get();


            pe.setDescription(propertyDTO.getDescription());



            dto=propertyConverter.convertEntityTODTO(pe);


            propertyRepository.save(pe);

        }
        return dto;
    }

    @Override
    public void deleteProperty(Long propertyId) {
        propertyRepository.deleteById(propertyId);
    }


    @Override
    public PropertyDTO updatePropertyPrice(PropertyDTO propertyDTO, Long propertyId) {
        Optional<PropertyEntity> option= propertyRepository.findById(propertyId);

        PropertyDTO dto=null;

        if(option.isPresent()){
            PropertyEntity pe =option.get();


            pe.setPrice(propertyDTO.getPrice());



            dto=propertyConverter.convertEntityTODTO(pe);


            propertyRepository.save(pe);

        }
        return dto;
    }
}








//        PropertyEntity pe= new PropertyEntity();
//        pe.setTitle(propertyDTO.getTitle());
//        pe.setDescription(propertyDTO.getDescription());
//        pe.setAddress(propertyDTO.getAddress());
//        pe.setOwnerName(propertyDTO.getOwnerName());               //Our DTO Giving objects But our repository Taking entities. So we have to convert it. this convertion we do is called ADAPTER DESIGN PATTERN
//        pe.setOwnerEmail(propertyDTO.getOwnerEmail());
//        pe.setPrice(propertyDTO.getPrice());







