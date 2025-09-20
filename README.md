# Daily Coding Problem — Java

Repo di esercizi in Java, un modulo per ogni esercizio (`exNNN-slug`).

## Come eseguire i test
```bash
mvn -q -T 1C clean verify
mvn -q -pl exercises/ex001-two-sum -am test
```
To check code format 

```bash
mvn checkstyle:check 
```

If you want to run the code formatter for a single project run the code

```bash
mvn -q -f exercises/ex001-two-sum/pom.xml checkstyle:check 
```