#!/usr/bin/env bash
set -euo pipefail
ID="$1"           # es: 002
SLUG="$2"         # es: linked-list-cycle
ARTIFACT="ex${ID}-${SLUG}"
BASE="exercises/${ARTIFACT}"
PKG="io/github/mburatta/ex${ID}"

mkdir -p "${BASE}/src/main/java/${PKG}" "${BASE}/src/test/java/${PKG}"

cat > "${BASE}/pom.xml" <<EOF
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
  <modelVersion>4.0.0</modelVersion>
  <parent>
    <groupId>it.mburatta</groupId>
    <artifactId>daily-coding-problem-java</artifactId>
    <version>1.0.0-SNAPSHOT</version>
  </parent>
  <artifactId>${ARTIFACT}</artifactId>
  <dependencies>
    <dependency>
      <groupId>org.junit.jupiter</groupId>
      <artifactId>junit-jupiter</artifactId>
      <scope>test</scope>
    </dependency>
    <dependency>
      <groupId>org.assertj</groupId>
      <artifactId>assertj-core</artifactId>
      <scope>test</scope>
    </dependency>
  </dependencies>
</project>
EOF

# Aggiorna modules nel pom root (evita duplicati)
if ! grep -q "<module>${BASE}</module>" pom.xml; then
  awk -v m="    <module>${BASE}</module>" '
    /<modules>/ {print; print m; skip=1; next}
    {print}
  ' pom.xml > pom.xml.tmp && mv pom.xml.tmp pom.xml
fi

# Template class e test
cat > "${BASE}/src/main/java/${PKG}/Solution.java" <<EOF
package it.mburatta.ex${ID};

public final class Solution {
  private Solution() {}
  // TODO: implementa qui
}
EOF

cat > "${BASE}/src/test/java/${PKG}/SolutionTest.java" <<EOF
package it.mburatta.ex${ID};

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;

class SolutionTest {
  @Test
  void placeholder() {
    assertThat(1 + 1).isEqualTo(2);
  }
}
EOF

echo "Creato modulo: ${ARTIFACT}"
