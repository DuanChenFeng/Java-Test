package com.sitech.security;

/**
*@author 段道博
*@date 2019年12月30日下午4:56:49
*
*/


/*@Service
public class UserDetailsServiceImpl implements UserDetailsService{
	@Resource
	private LoginMapper loginMapper;
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		String password = "4db1bdc0-dc4a-4467-b8e8-52322297ca1a";
		
		List<Integer> roleList = loginMapper.user_role(username);
		
		List<GrantedAuthority> grantedAuthorityList = new ArrayList<>();
		
		if (roleList != null && roleList.size() > 0) {
			for (Integer role : roleList) {
				grantedAuthorityList.add(new SimpleGrantedAuthority(role.toString()));
			}
		}
		
		return new User(username, password, grantedAuthorityList);
	}
}*/

