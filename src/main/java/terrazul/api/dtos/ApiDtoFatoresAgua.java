package terrazul.api.dtos;

import jakarta.validation.constraints.NotBlank;

public class ApiDtoFatoresAgua {

    @NotBlank
    private String fator;

    public String getFator() {
        return fator;
    }

    public void setFator(String fator) {
        this.fator = fator;
    }
}
