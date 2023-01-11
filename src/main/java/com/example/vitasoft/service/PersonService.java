package com.example.vitasoft.service;

import com.example.vitasoft.dto.PersonDto;
import com.example.vitasoft.exception.AllException;
import com.example.vitasoft.mapper.PersonMapper;
import com.example.vitasoft.model.Person;
import com.example.vitasoft.model.Role;
import com.example.vitasoft.repository.PersonRepository;
import com.example.vitasoft.secyrity.SecurityUser;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Log4j2
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class PersonService implements UserDetailsService {
    private final PersonRepository personRepository;
    private final PersonMapper mapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Person person = personRepository.findByEmail(username).orElseThrow(() ->
                new UsernameNotFoundException("Пользователь не существует"));
        return SecurityUser.fromUser(person);
    }

    public Optional<List<PersonDto>> findAll() {

        List<Person> personList = personRepository.findAll();

        return Optional.ofNullable(Optional.of(personList.stream()
                        .map(mapper::convertToPersonDto)
                        .collect(Collectors.toList()))
                .orElseThrow(() -> new AllException(("Ошибка вызова, обратитесь к администратору"))));
    }

    public PersonDto addOperator(Long id) {
        Optional<Person> person = personRepository.findById(id);

        if(person.isPresent()){

            Set<Role> role = person.get().getRole();
            role.add(Role.OPERATOR);
            person.get().setRole(role);

            mapper.convertToPersonDto(save);

        }
        return null;
    }

}
