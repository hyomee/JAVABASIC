package com.hyomee.cleancode;

import java.util.Optional;

public class NullToOprional {
    public static void main(String[] str) {
        NullReturn nullReturn = new NullReturn();
        SamleDTO samleDTONullPeturn= nullReturn.getSamleDTO();
        if (samleDTONullPeturn == null) {
            System.out.println("### samleDTONullPeturn SamleDTO은 null 입니다.");
        } else {
            samleDTONullPeturn.printSampleDTO("Data....");
        }

        OptionalReturn optionalReturn = new OptionalReturn();
        SamleDTO samleDTOOptionalNull = optionalReturn.getSamleDTO()
                .orElse(null);
        if (samleDTONullPeturn == null) {
            System.out.println("### samleDTOOptionalNull :: SamleDTO은 null 입니다.");
        } else {
            samleDTONullPeturn.printSampleDTO("Data....");
        }

        optionalReturn.getSamleDTO().ifPresent(samleDTO2 -> samleDTO2.printSampleDTO("Data...."));

    }
}


class NullReturn {
    private SamleDTO samleDTO;

    public SamleDTO getSamleDTO() {
        return samleDTO;
    }
}

class OptionalReturn {
    private SamleDTO samleDTO;

    public Optional<SamleDTO> getSamleDTO() {
        return Optional.ofNullable(samleDTO);
    }
}

class SamleDTO {
    private String name;
    private String code;

    public void printSampleDTO(String str) {
        System.out.println("### 출력 " + str );
    }
}