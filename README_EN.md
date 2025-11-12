# Advanced Programming | Lab7

# 💻 Laboratory Exercise — *Observer* Pattern
## Topic: *Bag of Words*

---

## 🎯 **Objectives**
- Understand and apply the **Observer pattern**.
- Separate responsibilities between **Model** and **View**.
- Make the graphical interface (JavaFX) **automatically update** when the model changes.
- Add a **console view** that also observes the same model.

---

## 🧩 **Base Code**

The provided code is organized as follows:

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

The application already provides a simple interface to manage a list of words (*bag of words*).

---

## 🧠 **Exercise 1 — Applying the Observer Pattern**

### 🪜 Steps

1. **Study the provided code**
    - Run the application and observe its current behaviour.
    - Identify the main classes:
        - `BagOfWords` → represents the **model** (stores the list of words);
        - `BagOfWordsView` → represents the **graphical view** (JavaFX);
        - `observer` → contains the generic interfaces for the *Observer* pattern.

2. **Apply the Observer pattern**
    - Make `BagOfWords` act as a **Subject**.
    - Make `BagOfWordsView` act as an **Observer**.
    - Register the view in the model (`model.addObservers(this)`).
    - Ensure that whenever the model changes (add, remove, or clear words), the view is notified and updates:
        - the list (`ListView`);
        - and the word counter (`Label`).

3. **Verify the behaviour**
    - When adding, removing, or clearing words, the interface must update automatically — **without** manually updating the UI outside the `update(...)` method.

---

## 🖥️ **Exercise 2 — Console View**

### 1️⃣ Create a new class `BagOfWordsConsoleView`
- This class will be a **second view**, in text mode.
- It must **implement** the `Observer` interface.
- In the constructor, register it with the model:
  ```java
  model.addObservers(this);
  ```

### 2️⃣ In the `update(Object obj)` method
- Print in the console the type of change and the current content of the bag.  
  Example output:
  ```
  [CLI] ADDED 'test' (size=4)
  Current content: [one, two, three, test]
  ```

### 3️⃣ Register the console view
- In `FactoryMVPBag.java`, after creating the model and the graphical view, add:
  ```java
  BagOfWordsConsoleView consoleView = new BagOfWordsConsoleView(model);
  ```

Now, whenever you interact with the graphical interface (add, remove, clear), you should also see updates printed in the console.

---

## ✅ **Expected Results**
- Both the graphical and console views always reflect the **current state** of the model.
- The model **automatically notifies** all observers when it changes.
- The *Observer* pattern is correctly applied, without direct dependencies between model and views.

---
