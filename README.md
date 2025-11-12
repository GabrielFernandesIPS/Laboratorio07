# Programação Avançada | Lab7

:gb: [English version](README_EN.md)

# 💻 Trabalho de Laboratório — Padrão *Observer*
## Tema: *Bag of Words* (Bolsa de Palavras)

---

## 🎯 **Objetivos**
- Compreender e aplicar o **padrão Observer**.
- Separar as responsabilidades entre **modelo** e **vista**.
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
    - Executa a aplicação e observa o seu comportamento atual.
    - Identifica as classes principais:
        - `BagOfWords` → representa o **modelo** (contém a lista de palavras);
        - `BagOfWordsView` → representa a **vista gráfica** (JavaFX);
        - `observer` → contém as interfaces genéricas do padrão *Observer*.

2. **Aplica o padrão Observer**
    - Faz com que `BagOfWords` seja um **Subject**.
    - Faz com que `BagOfWordsView` seja um **Observer**.
    - Regista a vista no modelo (`model.addObservers(this)`).
    - Garante que, sempre que o modelo muda (adicionar, remover ou limpar palavras), a vista é notificada e atualiza:
        - a lista (`ListView`);
        - e o contador de palavras (`Label`).

3. **Verifica o comportamento**
    - Ao adicionar, remover ou limpar palavras, a interface deve atualizar-se automaticamente — **sem** precisar de atualizar manualmente a UI fora do método `update(...)`.

---

## 🖥️ **Exercício 2 — Vista em modo consola**

### 1️⃣ Cria uma nova classe `BagOfWordsConsoleView`
- Esta classe será uma **segunda vista**, em modo texto.
- Deve **implementar** a interface `Observer`.
- No construtor, regista-se no modelo:
  ```java
  model.addObservers(this);
  ```

### 2️⃣ No método `update(Object obj)`
- Mostra no terminal o tipo de alteração ocorrida e o estado atual da “bag”.  
  Exemplo de saída:
  ```
  [CLI] ADDED 'teste' (size=4)
  Conteúdo atual: [um, dois, três, teste]
  ```

### 3️⃣ Regista a vista de consola
- Em `FactoryMVPBag.java`, depois de criar o modelo e a vista gráfica, adiciona:
  ```java
  BagOfWordsConsoleView consoleView = new BagOfWordsConsoleView(model);
  ```

Agora, sempre que interagires com a interface gráfica (adicionar, remover, limpar), verás também as atualizações no terminal.

---

## ✅ **Objetivos a alcançar**
- A vista gráfica e a vista de consola refletem sempre o **estado atual** do modelo.
- O modelo **notifica automaticamente** os observadores sempre que muda.
- O padrão *Observer* está corretamente aplicado, sem dependências diretas entre modelo e vistas.


