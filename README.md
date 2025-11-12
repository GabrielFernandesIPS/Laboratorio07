# Programação Avançada | Lab7

:gb: [English version](README_EN.md)

# 💻 Trabalho de Laboratório — Padrão *Observer*
## Tema: *Bag of Words* (Bolsa de Palavras)

---

## 🎯 **Objetivos**
- Compreender e aplicar o **padrão Observer**.
- Separar as responsabilidades entre **modelo** (M-Model) e **vista** (V-View).
- Fazer com que a interface gráfica (JavaFX) se **atualize automaticamente** quando o modelo muda.
- Adicionar uma **vista em modo consola** que também observe o mesmo modelo.

---

## 🧩 **Código Base**

O código fornecido encontra-se organizado da seguinte forma:

```
MV/
  Main.java
  FactoryMVBag.java
  model/
    BagOfWords.java
    BagOfWordsException.java
  view/
    BagOfWordsView.java
observer/
  Observer.java
  Subject.java
  Observable.java
```

A aplicação já cria uma interface simples para gerir uma lista de palavras (*bag of words*).

---

##  **Exercício 1 — Aplicação do padrão Observer**

### 🪜 Passos a realizar

1. **Estuda o código fornecido**
    - Executa a aplicação e observa o seu comportamento atual. Constata que as ações nos botões não tem o comportamento esperado, já que aparece modificado na GUI.
    - Identifica as componentes principais:
        - `BagOfWords` → representa o **modelo** (contém a lista de palavras);
        - `BagOfWordsGUI` → representa a **vista gráfica** (JavaFX);
        - pacote `observer` → contém as interfaces genéricas do padrão *Observer*.

2. **Aplica o padrão Observer**: Pretende-se aplicar o padrão Observer de forma obter o comportamento esperado, quando se pressiona um dos botões ( adicionar palavra à lista de palavras, ou remove-las)
   
    - Faz com que `BagOfWords` seja um **Subject**.
    - Faz com que `BagOfWordsGUI` seja um **Observer**.
    - Regista a vista no modelo (`model.addObservers(this)`).
    - Garante que, sempre que o modelo muda (adicionar, remover ou limpar palavras), a vista é notificada e atualiza:
        - a lista (`ListView`);
        - e o contador de palavras (`Label`).

4. **Verifica o comportamento**
    - Ao adicionar, remover ou limpar palavras, a interface deve atualizar-se automaticamente — **sem** precisar de atualizar manualmente a UI fora do método `update(...)`.

---

## 🖥️ **Exercício 2 — Vista em modo consola**

### 1 Cria uma nova classe `BagOfWordsConsoleView`
- Esta classe será uma **segunda vista**, em modo texto.
- Deve **implementar** a interface `Observer`.
- No construtor, regista-se no modelo:
  ```java
  model.addObservers(this);
  ```

### 2 No método `update(Object obj)`
- Mostra no terminal o tipo de alteração ocorrida e o estado atual da “bag”.  
  Exemplo de saída:
  ```
  [CLI] ADDED 'teste' (size=4)
  Conteúdo atual: [um, dois, três, teste]
  ```

### 3 Regista a vista de consola
- Em `FactoryMVPBag.java`, depois de criar o modelo e a vista gráfica, adiciona:
  ```java
  BagOfWordsConsoleView consoleView = new BagOfWordsConsoleView(model);
  ```

Agora, sempre que interagires com a interface gráfica (adicionar, limpar), verás também as atualizações no terminal.

### 4 Adiciona a funcionalidade de remover um item especifico da lista de palavras
- Altera as classes:
  - BagOfWordsGUI 
  - BagOfWordsConsole
  - BagOfWords
  De forma a que quando se seleciona um item e se aciona o botão Remove (a adicionar à interface), o item é removido da lista e o numero de palavras adicionada.
---

## ✅ **Objetivos a alcançar**
- A vista gráfica e a vista de consola refletem sempre o **estado atual** do modelo.
- O modelo **notifica automaticamente** os observadores sempre que muda.
- O padrão *Observer* está corretamente aplicado, sem dependências diretas entre modelo e vistas.


