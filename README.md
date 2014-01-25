:In The Name of Allah:

btree-dic
=========

The data structure course final project

Compilation:
------------

Just run:

```bash
$ javac src/Main.java
```

Then put your CSV file in `./data` and change it's name to `source.csv`.
Your CSV file must delimits each cell with `~` and fields each text block
with `|`.
If the given file have other formats the program will throws exceptions.

Usage:
------

```bash
$ java Main word|--parse [source CSV file path]
```

After the source file being parsed, in further run the program just extracts
datas from `data//dictionary.dict` file and takes lookup and find things.

Why Java?
*********

The java `Serializable` objects and the classes `ObjectOutputStream` and
`ObjectInputStream` handles pointer problem with saving dynamic data-structures
on a secondary memory.
Also if `ObjectInputStream` and `ObjectOutputStream` using `BufferedInputStream`
and `BufferedOutputStream` (corresponding), the JVM handles access violations
and calls a disk-read request iff the requested object was not accessed
before now so it does not take loading full object in memory but just loading
that part that we need now. So this program takes the
time enhancement advantages of B-Tree data-structure in secondary memory
accessing violations and times.

Licensing:
**********

**Copyright ARF1372 (2013 - now) licensed under GNU/GPLv3 or earlier versions**
**See `LICENSE` File For More Informations.**

