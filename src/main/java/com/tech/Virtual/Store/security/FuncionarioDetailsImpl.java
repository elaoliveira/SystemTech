package com.tech.Virtual.Store.security;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.tech.Virtual.Store.model.Funcionario;

public class FuncionarioDetailsImpl implements UserDetails {
	
	private static final long serialVersionUID = 1L;
    private String funcionarioEmail;
    private String password;
    private List<GrantedAuthority> authorization;

    public FuncionarioDetailsImpl() {};

    public FuncionarioDetailsImpl(Funcionario costumer) {
        this.funcionarioEmail = costumer.getEmail();
        this.password = costumer.getSenha();

    }


	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return authorization;
	}
	

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return password;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return funcionarioEmail;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

	
}
