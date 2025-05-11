package umc.study.converter;

import umc.study.domain.Member;
import umc.study.domain.enums.Gender;
import umc.study.web.dto.MemberRequestDTO;
import umc.study.web.dto.MemberResponseDTO;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class MemberConverter {

    public static MemberResponseDTO.JoinResultDTO toJoinResultDTO(Member member){
        return MemberResponseDTO.JoinResultDTO.builder()
                .memberId(member.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static MemberResponseDTO.LoginResultDTO toLoginResultDTO(Long memberId, String accessToken) {
        return MemberResponseDTO.LoginResultDTO.builder()
                .memberId(memberId)
                .accessToken(accessToken)
                .build();
    }

    public static MemberResponseDTO.MemberInfoDTO toMemberInfoDTO(Member member){
        return MemberResponseDTO.MemberInfoDTO.builder()
                .name(member.getName())
                .email(member.getEmail())
                .gender(member.getGender().name())
                .build();
    }

    public static Member toMember(MemberRequestDTO.JoinDto request){
        return Member.builder()
            .email(request.getEmail())
            .password(request.getPassword())
            .address(request.getAddress())
            .specAddress(request.getSpecAddress())
            .gender(request.getGender())
            .name(request.getName())
            .role(request.getRole())
            .memberPreferList(new ArrayList<>())
            .build();
    }
}
