package hackathon.banco.safra.easyway.adapters.persistence.enums.converters;

import hackathon.banco.safra.easyway.adapters.persistence.enums.InvestmentProfileDataEnum;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class InvestmentProfileDataEnumConverter implements AttributeConverter<InvestmentProfileDataEnum, Integer> {

    @Override
    public Integer convertToDatabaseColumn(InvestmentProfileDataEnum investmentProfileDataEnum) {
        if(investmentProfileDataEnum == null){
            return null;
        }
        return investmentProfileDataEnum.getCode();
    }

    @Override
    public InvestmentProfileDataEnum convertToEntityAttribute(Integer code) {
        return InvestmentProfileDataEnum.fromCode(code);
    }
}
