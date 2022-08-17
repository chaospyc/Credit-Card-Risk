package com.chaossnow.ms.dto.impl;



import static com.chaossnow.ms.util.BeanUtils.updateProperties;

public interface OutputConverter<DTO extends OutputConverter<DTO,DOMAIN>,DOMAIN> {


    default<T extends DTO> T convertFrom( DOMAIN domain){
        updateProperties(domain,this);
        return (T) this;
    }
}
