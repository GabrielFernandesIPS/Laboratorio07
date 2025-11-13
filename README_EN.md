# Advanced Programming | Lab7

# Laboratory Exercise — *Observer* Pattern
## Topic: *Bag of Words*

## **Objectives**

* Understand and apply the **Observer pattern**.
* Separate responsibilities between **model** (M – Model) and **view** (V – View).
* Ensure that the graphical interface (JavaFX) **updates automatically** when the model changes.
* Add a **console-based view** that also observes the same model.

---

## **Base Code**

The provided code is organised as follows:

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

The application already includes a simple interface for managing a list of words (*bag of words*).

---

## **Exercise 1 — Applying the Observer Pattern**

### Steps to carry out

1. **Study the provided code**

    * Run the application and observe its current behaviour.
    * Notice that when interacting with the buttons, **no updates** are reflected in the graphical interface — the actions appear to have no effect because the list and the counter remain unchanged.
    * Identify the main components:

        * `BagOfWords` → represents the **model** (contains the list of words);
        * `BagOfWordsGUI` → represents the **graphical view** (JavaFX);
        * the `observer` package contains the generic interfaces of the *Observer* pattern;
        * the class `FactoryMVBagGUI`, which implements a creation method responsible for connecting the view to the model.

2. **Apply the Observer pattern**
   The goal is to apply the Observer pattern so that the interface behaves correctly when the buttons are pressed (add word to the list, clear the list).

    * Make `BagOfWords` a **Subject**.
    * Make `BagOfWordsGUI` an **Observer**.
    * Register the view in the model (`model.addObservers(this)`) inside the `create` method of the `FactoryMVBagGUI` class.
    * Ensure that whenever the model changes (adding or clearing words), the view is notified and updates:

        * the list (`ListView`);
        * and the word counter (`Label`).

3. **Verify the behaviour**

    * When adding or clearing words, the interface should update automatically — **without** needing to update the UI manually outside the `update(...)` method.

---

## **Exercise 2 — Console View**

### 1. Create a new class `BagOfWordsConsoleView`

* This class will be a **second view**, in text mode.
* It must **implement** the `Observer` interface.

### 2. In the method `update(Object obj)`

* Display in the terminal the type of change that occurred and the current state of the bag.
  Example output:

  ```
  [CLI] ADDED 'test' (size=4)
  Current content: [one, two, three, test]
  ```

### 3. Create a new factory

* Create a class `FactoryMVPBagConsole.java` that receives the model, creates a console view and registers it as an observer.

Now, whenever you interact with the graphical interface (add, clear), you will also see updates printed in the terminal.

---

## **Exercise 3 — Add a “Draw Random Word” Functionality**

Implement a new feature that **allows drawing a random word** from the current list of words.

### **Modifications required**

You must modify the following classes:

* `BagOfWordsGUI`
* `BagOfWordsConsole`
* `BagOfWords`

### **Expected behaviour**

1. Add a **“Draw”** button to the graphical interface (`BagOfWordsGUI`).
2. When the user clicks this button:

    * A **random word** is selected from the list in the model (`BagOfWords`);
    * The word is **removed from the list**;
    * The **total number of words** updates automatically;
    * The drawn word is displayed to the user in a **`Label`** (or printed in the console for `BagOfWordsConsole`).

### **Notes**

* The random selection must be implemented in the **model** (`BagOfWords`), following the *Model–View* principle (the view must not contain data logic).
* The operation must **notify observers** so that both the graphical and console views update after the draw.
* If the list is empty, an appropriate warning message should be shown to the user.

---

## ✅ **Expected Outcomes**

* Both the graphical view and the console view always reflect the **current state** of the model.
* The model **automatically notifies** observers whenever it changes.
* The Observer pattern is correctly applied, with no direct dependencies between model and views.

---

If you want, I can also prepare a **bilingual version** (Portuguese & English together) or generate a **Markdown file** ready for download.

---
