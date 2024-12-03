package io.codeforall.fanstatics;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class Main {

    public static void main(String[] args) throws IOException {

        ObjectMapper mapper = new ObjectMapper();

        IPPojo myIp = mapper.readValue(new URL("https://ipinfo.io/json"), IPPojo.class);

        System.out.println("IP: " + myIp.getIp());
        System.out.println("City: " + myIp.getCity());
        System.out.println("Region: " + myIp.getRegion());
        System.out.println("Country: " + myIp.getCountry());
        System.out.println("Location: " + myIp.getLoc());
        System.out.println("Org: " + myIp.getOrg());
        System.out.println("Postal: " + myIp.getPostal());
        System.out.println("Timezone: " + myIp.getTimezone());
        System.out.println("Readme: " + myIp.getReadme());
    }

}
