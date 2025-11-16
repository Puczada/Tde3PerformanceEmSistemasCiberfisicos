Parte 2 — Threads e Semáforos

 Este documento apresenta explicações, códigos e pseudocódigos sobre a demonstração de condição de
 corrida e correção com semáforo binário em Java.
 
 1. Introdução

 Programas concorrentes podem sofrer com condições de corrida quando múltiplas threads acessam e
 modificam um recurso compartilhado sem sincronização adequada. Java fornece mecanismos como a
 classe Semaphore para controlar esse acesso.
 
 2. Semáforos

 Um semáforo mantém um contador de permissões. Cada acquire() consome uma permissão e bloqueia
 se nenhuma estiver disponível; cada release() a devolve. Quando inicializado com 1, funciona como
 exclusão mútua (semáforo binário).
 
 3. Experimento: Contador Concorrente

 O experimento consiste em duas versões: uma sem sincronização, exibindo condição de corrida, e outra
 sincronizada com semáforo binário.
 
 Pseudocódigo — Versão sem Sincronização

<img width="378" height="305" alt="image" src="https://github.com/user-attachments/assets/b1cbc03b-b24b-4882-99f8-47cc149ce626" />


 Código Java — Versão sem Sincronização

<img width="313" height="126" alt="image" src="https://github.com/user-attachments/assets/eae60aae-d552-485e-9b69-85b3523acc84" />


 Pseudocódigo — Versão com Semáforo Binário

<img width="328" height="233" alt="image" src="https://github.com/user-attachments/assets/8a7677c5-6559-4644-b1ad-d84e3842d2af" />

 
 Código Java — Versão com Semáforo

<img width="396" height="218" alt="image" src="https://github.com/user-attachments/assets/48123c36-afc3-424c-af5f-11ec9c3a64bf" />

 
 4. Conclusão
 
 A versão sem sincronização produz valores incorretos devido à condição de corrida. Já a versão com
 semáforo binário garante exclusão mútua, eliminando o problema ao custo de maior tempo de execução.
 O modo justo garante ordem FIFO entre threads, reduzindo throughput mas evitando starvation.
