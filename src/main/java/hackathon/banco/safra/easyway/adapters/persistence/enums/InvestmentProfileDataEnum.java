package hackathon.banco.safra.easyway.adapters.persistence.enums;

import hackathon.banco.safra.easyway.application.enums.InvestmentProfileEnum;
import lombok.Getter;

@Getter
public enum InvestmentProfileDataEnum {

    CONSERVATIVE(1, InvestmentProfileEnum.CONSERVATIVE),
    MODERATE(2, InvestmentProfileEnum.MODERATE),
    BOLD(3, InvestmentProfileEnum.BOLD),
    AGGRESSIVE(4, InvestmentProfileEnum.AGGRESSIVE);

    private final Integer code;
    private final InvestmentProfileEnum investmentProfileEnum;

    InvestmentProfileDataEnum(Integer code, InvestmentProfileEnum investmentProfileEnum) {
        this.code = code;
        this.investmentProfileEnum = investmentProfileEnum;
    }


    public Integer getCode(){return code;}

    public InvestmentProfileEnum getInvestmentProfileEnum(){return investmentProfileEnum;}

    public static InvestmentProfileDataEnum fromCode(Integer code){
        for (InvestmentProfileDataEnum investmentProfileDataEnum : InvestmentProfileDataEnum.values()){
            if(investmentProfileDataEnum.getCode().equals(code)){
                return investmentProfileDataEnum;
            }
        }
        return null;
    }

    public static InvestmentProfileDataEnum fromEnum(InvestmentProfileEnum investmentProfileEnum){
        for (InvestmentProfileDataEnum investmentProfileDataEnum : InvestmentProfileDataEnum.values()){
            if(investmentProfileDataEnum.getInvestmentProfileEnum() == investmentProfileEnum)
                return investmentProfileDataEnum;
        }
        return null;
    }

}
