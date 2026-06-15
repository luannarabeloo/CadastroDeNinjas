/*
  Arquivo criado temporariamente durante diagnóstico para tentar registrar o servlet da H2 Console.
  Acabei revertendo a alteração porque a versão do H2 usada no pom estava com escopo runtime
  e também havia incompatibilidade entre javax.servlet (usada pelo h2) e jakarta.servlet (usada
  pelo Spring Boot 4). Manter este arquivo ativo causaria erros de compilação.

  Se você quer que eu reative a solução integrada, posso:
   - trocar a versão do Spring Boot para 3.x (compatível com javax.servlet), ou
   - usar uma versão do H2 compatível com jakarta.servlet (se existir), ou
   - manter o H2 como runtime e executar o console H2 standalone com:

      java -jar %USERPROFILE%\.m2\repository\com\h2database\h2\2.4.240\h2-2.4.240.jar

  Por enquanto deixei este arquivo como comentário para não quebrar a build.
*/

