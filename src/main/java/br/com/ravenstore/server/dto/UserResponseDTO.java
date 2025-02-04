package br.com.ravenstore.server.dto;

import br.com.ravenstore.server.model.User;
import br.com.ravenstore.server.security.dto.AuthorityResponseDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

import java.util.HashSet;
import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserResponseDTO {
	private Long id;
	private String name;
	private String email;
	private String cpf;
	private Set<AuthorityResponseDTO> authorities;

	public UserResponseDTO(User user) {
		this.id = user.getId();
		this.name = user.getName();
		this.email = user.getEmail();
		this.cpf = user.getCpf();
		this.authorities = new HashSet<>();
		for (GrantedAuthority authority : user.getAuthorities()) {
			authorities.add(new AuthorityResponseDTO(authority.getAuthority()));
		}
	}

}