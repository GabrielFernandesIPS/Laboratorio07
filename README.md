# Programação Avançada | Lab7

:gb: [English version](README_EN.md)

# Trabalho de Laboratório — Padrão *Observer*
## Tema: *Bag of Words* (Bolsa de Palavras)

---

## **Objetivos**
- Compreender e aplicar o **padrão Observer**.
- Separar as responsabilidades entre **modelo** (M-Model) e **vista** (V-View).
- Fazer com que a interface gráfica (JavaFX) se **atualize automaticamente** quando o modelo muda.
- Adicionar uma **vista em modo consola** que também observe o mesmo modelo.

---

##  **Código Base**

O código fornecido encontra-se organizado da seguinte forma:

```
MV/
  Main.java
  FactoryMVBagGUI.java
  model/
    BagOfWords.java
    BagOfWordsException.java
  view/
    BagOfWordsGui.java
observer/
  Observer.java
  Subject.java
  Observable.java
```

A aplicação já cria uma interface simples para gerir uma lista de palavras (*bag of words*).

---

##  **Exercício 1 — Aplicação do padrão Observer**

###  Passos a realizar

1. **Estuda o código fornecido**
    - Executa a aplicação e observa o seu comportamento atual. 
    - Executa a aplicação e observa o seu comportamento atual.
      Verifica que, ao interagir com os botões, nenhuma atualização é refletida na interface gráfica — as ações parecem não ter efeito, pois a lista e o contador permanecem inalterados.
    - Identifica as componentes principais:
        - `BagOfWords` → representa o **modelo** (contém a lista de palavras);
        - `BagOfWordsGUI` → representa a **vista gráfica** (JavaFX);
        -  pacote `observer` contém as interfaces genéricas do padrão *Observer*.
        - a classe `FactoryMVBagGUI` que impleemnta um método de criação, responsavel por ligar a view ao modelo.

2. **Aplica o padrão Observer**: Pretende-se aplicar o padrão Observer de forma obter o comportamento esperado, quando se pressiona um dos botões ( adicionar palavra à lista de palavras, limpar a lista)
   
    - Faz com que `BagOfWords` seja um **Subject**.
    - Faz com que `BagOfWordsGUI` seja um **Observer**.
    - Regista a vista no modelo (`model.addObservers(this)`), no método create da classe `FactoryMVBagGUI`.
    - Garante que, sempre que o modelo muda (adicionar, ou limpar palavras), a vista é notificada e atualiza:
        - a lista (`ListView`);
        - e o contador de palavras (`Label`).

4. **Verifica o comportamento**
    - Ao adicionar, ou limpar palavras, a interface deve atualizar-se automaticamente — **sem** precisar de atualizar manualmente a UI fora do método `update(...)`.

---

## *Exercício 2 — Vista em modo consola**

### 1 Cria uma nova classe `BagOfWordsConsoleView`
- Esta classe será uma **segunda vista**, em modo texto.
- Deve **implementar** a interface `Observer`.

### 2 No método `update(Object obj)`
- Mostra no terminal o tipo de alteração ocorrida e o estado atual da “bag”.  
  Exemplo de saída:
  ```
  [CLI] ADDED 'teste' (size=4)
  Conteúdo atual: [um, dois, três, teste]
  ```

### 3 Cria uma nova fabrica 
- Cria uma classe `FactoryMVPBagConsole.java`, que recebe o modelo e cria uma vista do tipo consola e regista-a como observador.


Agora, sempre que interagires com a interface gráfica (adicionar, limpar), verás também as atualizações no terminal.

## Exercicio 3 -  Adicionar funcionalidade de sorteio de uma palavra
Implementa uma nova funcionalidade que **permite sortear uma palavra aleatória** da lista de palavras existente.

#### **Alterações a realizar**
Deverás modificar as seguintes classes:
- `BagOfWordsGUI`
- `BagOfWordsConsole`
- `BagOfWords`

#### **Comportamento pretendido**
1. Adiciona à interface gráfica (`BagOfWordsGUI`) um **botão “Sorteio”**.
2. Quando o utilizador clica nesse botão:
    - Uma **palavra é escolhida aleatoriamente** da lista de palavras do modelo (`BagOfWords`);
    - A palavra **é removida da lista**;
    - O **número total de palavras** é atualizado automaticamente;
    - A palavra sorteada é apresentada ao utilizador num **`Label`** (ou impressa na consola, no caso da `BagOfWordsConsole`).

#### **Notas**
- O sorteio deve ser realizado no **modelo** (`BagOfWords`), mantendo o princípio *Model–View* (a lógica de dados não deve estar na vista).
- A operação deve **notificar os observadores**, para que tanto a vista gráfica como a vista em consola sejam atualizadas após o sorteio.
- Se a lista estiver vazia, deve ser apresentada uma mensagem de aviso ao utilizador.

---



## ✅ **Objetivos a alcançar**
- A vista gráfica e a vista de consola refletem sempre o **estado atual** do modelo.
- O modelo **notifica automaticamente** os observadores sempre que muda.
- O padrão *Observer* está corretamente aplicado, sem dependências diretas entre modelo e vistas.


