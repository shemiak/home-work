package com.sbrf.reboot.repository.impl;

import com.sbrf.reboot.repository.AccountRepository;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class FileAccountRepository implements AccountRepository {
    private final String filePath;

    public FileAccountRepository(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public Set<Long> getAllAccountsByClientId(long clientId) {
        Set<Long> setOfNumbers = new HashSet<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line = reader.readLine();
            long number;
            long clientIdParse = 0;
            while (line != null) {
                if (line.contains("clientId")) {
                    clientIdParse = Long.parseLong(line.substring(line.lastIndexOf(" ") + 1, line.indexOf(",")));
                }
                if (line.contains("number") && clientId == clientIdParse) {
                    number = Long.parseLong(line.substring(line.lastIndexOf(" ") + 1));
                    setOfNumbers.add(number);
                }

                line = reader.readLine();
            }
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
            return null;
        }

        return setOfNumbers;
    }

    @Override
    public Long getAccountByClientId(long clientId) {
        return null;
    }
}
