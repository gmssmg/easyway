package hackathon.banco.safra.easyway.application.enums;

import lombok.Getter;

@Getter
public enum InvestmentProfileEnum {

    CONSERVATIVE(1, "CONSERVATIVE"),
    MODERATE(2, "MODERATE"),
    BOLD(3, "BOLD"),
    AGGRESSIVE(4, "AGGRESSIVE");

    private final Integer code;
    private final String description;

    InvestmentProfileEnum(Integer code, String description) {
        this.code = code;
        this.description = description;
    }

    public static InvestmentProfileEnum fromDescription(String description){
        for (InvestmentProfileEnum investmentProfileEnum : InvestmentProfileEnum.values()){
            if(investmentProfileEnum.getDescription().equals(description)){
                return investmentProfileEnum;
            }
        }
        return null;
    }

}
