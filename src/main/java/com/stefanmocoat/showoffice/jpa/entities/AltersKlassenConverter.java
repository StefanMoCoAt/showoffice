package com.stefanmocoat.showoffice.jpa.entities;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class AltersKlassenConverter implements AttributeConverter<AltersKlasse, String> {

    @Override
    public String convertToDatabaseColumn(AltersKlasse attribute) {
        return attribute.getWerte();
    }

    @Override
    public AltersKlasse convertToEntityAttribute(String dbData) {
        return AltersKlasse.findByCode(dbData);
    }
}