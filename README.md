# Débuggez une application Java

## Structure

- Code in [src/com/hemebiotech/analytics](src/com/hemebiotech/analytics)
- Input : symptoms list in [data/symptoms.txt](data/symptoms.txt)
- Output : symptoms count in [data/result.out](data/result.out)

## Usage

- Compile

```console
javac -d target src/com/hemebiotech/analytics/*.java
```

- Execute

```console
java -cp "src;target" com.hemebiotech.analytics.Main
```
