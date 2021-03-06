package com.azaderdogan.accountservice.repository.cassandra;

import com.azaderdogan.accountservice.entity.Account;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends CassandraRepository<Account, String> {

    Account getAccountByNameAndUsername(String username,String name);

}
