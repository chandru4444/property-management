package com.mycompany.property_management.converter;

import com.mycompany.property_management.dto.PropertyDTO;
import com.mycompany.property_management.entity.PropertyEntity;
import org.springframework.stereotype.Component;

@Component
                                                                                    //this created because  writing setgettitle like that in the service layer is not a good practice
public class PropertyConverter {
    public PropertyEntity convertDTOtoEntity(PropertyDTO propertyDTO) {


        PropertyEntity pe = new PropertyEntity();

        pe.setTitle(propertyDTO.getTitle());
        pe.setDescription(propertyDTO.getDescription());
        pe.setAddress(propertyDTO.getAddress());
        pe.setOwnerName(propertyDTO.getOwnerName());               //Our DTO Giving objects But our repository Taking entities. So we have to convert it. this convertion we do is called ADAPTER DESIGN PATTERN
        pe.setOwnerEmail(propertyDTO.getOwnerEmail());
        pe.setPrice(propertyDTO.getPrice());


        return pe;
    }

    public PropertyDTO convertEntityTODTO(PropertyEntity propertyEntity) {

        PropertyDTO propertyDTO = new PropertyDTO();


        propertyDTO.setId(propertyEntity.getId());
        propertyDTO.setTitle(propertyEntity.getTitle());
        propertyDTO.setDescription(propertyEntity.getDescription());
        propertyDTO.setAddress(propertyEntity.getAddress());
        propertyDTO.setOwnerName(propertyEntity.getOwnerName());               //Our DTO Giving objects But our repository Taking entities. So we have to convert it. this convertion we do is called ADAPTER DESIGN PATTERN
        propertyDTO.setOwnerEmail(propertyEntity.getOwnerEmail());
        propertyDTO.setPrice(propertyEntity.getPrice());

            return propertyDTO;

    }
}