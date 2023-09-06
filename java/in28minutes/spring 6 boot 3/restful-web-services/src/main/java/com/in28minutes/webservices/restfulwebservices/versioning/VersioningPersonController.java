package com.in28minutes.webservices.restfulwebservices.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersioningPersonController {

    @GetMapping("/v1/person")
    public PersonV1 getFirstVersionOfPerson() {
        return new PersonV1("Bob Charlie");
    }

    @GetMapping("/v2/person")
    public PersonV2 getSecondVersionOfPerson() {
        return new PersonV2(new Name("Bob", "charli"));
    }

    @GetMapping(path = "/person", params = "version=1")
    public PersonV1 getFirstVersionOfPersonPrams() {
        return new PersonV1("Bob Charlie");
    }

    @GetMapping(path = "person", params = "version=2")
    public PersonV2 getSecondVersionOfPersonPrams() {
        return new PersonV2(new Name("Bob", "charli"));
    }

    @GetMapping(path = "/person", headers = "X-API-VERSION=1")
    public PersonV1 getFirstVersionOfPersonHeader() {
        return new PersonV1("Bob Charlie");
    }

    @GetMapping(path = "/person", headers = "X-API-VERSION=2")
    public PersonV2 getSecondVersionOfPersonHeader() {
        return new PersonV2(new Name("Bob", "charli"));
    }

    @GetMapping(path = "/person", produces = "application/V1+json")
    public PersonV1 getFirstVersionOfPersonAccept() {
        return new PersonV1("Bob Charlie");
    }

    @GetMapping(path = "/person", produces = "application/V2+json")
    public PersonV2 getSecondVersionOfPersonAccept() {
        return new PersonV2(new Name("Bob", "charli"));
    }
}
