#Gonnot Vianney et Gailhac Louis
# hadoop-examples-mapreduce
# MapReduce2 JAVA

###### lien vers mon github :`https://github.com/Vianneygonnot/hadoop-examples-mapreduce.git`

##  1.8.1 Districts containing trees

Write a MapReduce job that displays the list of distinct containing trees in this
file. Obviously, it's twenty or less different arrondissements, but exactly how
many?
You just need to put rounding as a key and put any value or NullWritable
as a value, output from the mapper.
The reducer will just have to output the keys and values it receives, it doesn't
even have to loop through the values since it ignores them.

```
-sh-4.2$ hdfs dfs -cat /user/vgonnot/districts1/part-r-00000
11
12
13
14
15
16
17
18
19
20
3
4
5
6
7
8
9

```

```
-sh-4.2$ yarn jar /home/vgonnot/hadoop-examples-mapreduce-1.0-SNAPSHOT-jar-with-dependencies.jar \districts /user/vgonnot/hive/trees.csv /user/vgonnot/districts1

```

## 1.8.2 Show all existing species

Write a MapReduce job that displays the list of different species trees in this file.

```
yarn jar /home/vgonnot/hadoop-examples-mapreduce-1.0-SNAPSHOT-jar-with-dependencies.jar \show /user/vgonnot/hive/trees.csv /user/vgonnot/show

-sh-4.2$ hdfs dfs -cat /user/vgonnot/show/part-r-00000 
```

```
 araucana
atlantica
australis
baccata
bignonioides
biloba
bungeana
cappadocicum
carpinifolia
colurna
coulteri
decurrens
dioicus
distichum
excelsior
fraxinifolia
giganteum
giraldii
glutinosa
grandiflora
hippocastanum
ilex
involucrata
japonicum
kaki
libanii
monspessulanum
nigra
nigra laricio
opalus
orientalis
papyrifera
petraea
pomifera
pseudoacacia
sempervirens
serrata
stenoptera
suber
sylvatica
tomentosa
tulipifera
ulmoides
virginiana
acerifolia

```

## 1.8.3 Number of trees by species

Write a MapReduce job that calculates the number of trees of each species.
For example, there are 3 Acer, 19 Platanus, etc. How will you dene the keys
and values passed between the mapper and the reducer?
The mapper must extract the kind of tree. The reducer gets the pairs (keyI,
valueI) with the same key, so this key must be the kind of tree; the value being
the number of such trees.



```
yarn jar /home/vgonnot/hadoop-examples-mapreduce-1.0-SNAPSHOT-jar-with-dependencies.jar \numbertree /user/vgonnot/hive/trees.csv /user/vgonnot/numbert


-sh-4.2$ hdfs dfs -cat /user/vgonnot/numbert/part-r-00000  
```

```
araucana        1
atlantica       2
australis       1
baccata 2
bignonioides    1
biloba  5
bungeana        1
cappadocicum    1
carpinifolia    4
colurna 3
coulteri        1
decurrens       1
dioicus 1
distichum       3
excelsior       1
fraxinifolia    2
giganteum       5
giraldii        1
glutinosa       1
grandiflora     1
hippocastanum   3
ilex    1
involucrata     1
japonicum       1
kaki    2
libanii 2
monspessulanum  1
nigra   3
nigra laricio   1
opalus  1
orientalis      8
papyrifera      1
petraea 2
pomifera        1
pseudoacacia    1
sempervirens    1
serrata 1
stenoptera      1
suber   1
sylvatica       8
tomentosa       2
tulipifera      2
ulmoides        1
virginiana      2
x acerifolia    11

```

## 1.8.4 Maximum height per specie of tree (average)

Write an MapReduce job that calculates the height of the tallest tree of each
kind.
For example, the tallest Acer is 16m, the tallest Platanus is 45m, etc.

```
yarn jar /home/vgonnot/hadoop-examples-mapreduce-1.0-SNAPSHOT-jar-with-dependencies.jar \highest /user/vgonnot/hive/trees.csv /user/vgonnot/highest

-sh-4.2$ hdfs dfs -cat /user/vgonnot/highest/part-r-00000
```

```
araucana        9.0
atlantica       25.0
australis       16.0
baccata 13.0
bignonioides    15.0
biloba  33.0
bungeana        10.0
cappadocicum    16.0
carpinifolia    30.0
colurna 20.0
coulteri        14.0
decurrens       20.0
dioicus 10.0
distichum       35.0
excelsior       30.0
fraxinifolia    27.0
giganteum       35.0
giraldii        35.0
glutinosa       16.0
grandiflora     12.0
hippocastanum   30.0
ilex    15.0
involucrata     12.0
japonicum       10.0
kaki    14.0
libanii 30.0
monspessulanum  12.0
nigra   30.0
nigra laricio   30.0
opalus  15.0
orientalis      34.0
papyrifera      12.0
petraea 31.0
pomifera        13.0
pseudoacacia    11.0
sempervirens    30.0
serrata 18.0
stenoptera      30.0
suber   10.0
sylvatica       30.0
tomentosa       20.0
tulipifera      35.0
ulmoides        12.0
virginiana      14.0
x acerifolia    45.0

```

## 1.8.5 Sort the trees height from smallest to largest (average)

###### Write an MapReduce job that sort the trees height from smallest to largest.

```
yarn jar /home/vgonnot/hadoop-examples-mapreduce-1.0-SNAPSHOT-jar-with-dependencies.jar \sortheight /user/vgonnot/hive/trees.csv /user/vgonnot/sort2


-sh-4.2$ hdfs dfs -cat /user/vgonnot/sort2/part-r-00000                                             2.0     3
5.0     89
6.0     62
9.0     39
10.0    44
10.0    32
10.0    95
10.0    61
10.0    63
11.0    4
12.0    93
12.0    66
12.0    50
12.0    7
12.0    48
12.0    58
12.0    33
12.0    71
13.0    36
13.0    6
14.0    68
14.0    96
14.0    94
15.0    91
15.0    5
15.0    70
15.0    2
15.0    98
16.0    28
16.0    78
16.0    75
16.0    16
18.0    64
18.0    83
18.0    23
18.0    60
20.0    34
20.0    51
20.0    43
20.0    15
20.0    11
20.0    1
20.0    8
20.0    20
20.0    35
20.0    12
20.0    87
20.0    13
22.0    10
22.0    47
22.0    86
22.0    14
22.0    88
23.0    18
25.0    24
25.0    31
25.0    92
25.0    49
25.0    97
25.0    84
26.0    73
27.0    65
27.0    42
28.0    85
30.0    76
30.0    19
30.0    72
30.0    54
30.0    29
30.0    27
30.0    25
30.0    41
30.0    77
30.0    55
30.0    69
30.0    38
30.0    59
30.0    52
30.0    37
30.0    22
30.0    30
31.0    80
31.0    9
32.0    82
33.0    46
34.0    45
35.0    56
35.0    81
35.0    17
35.0    53
35.0    57
40.0    26
40.0    74
40.0    40
42.0    90
45.0    21

```

# 1.8.6 District containing the oldest tree

Write a MapReduce job that displays the district where the oldest tree is.
The mapper must extract the age and district of each tree.

The problem is, this information can't be used as keys and values (why?). You
will need to dene a subclass of Writable to contain both information.

The reducer should consolidate all this data and only output district.

`-sh-4.2$ yarn jar /home/vgonnot/hadoop-examples-mapreduce-1.0-SNAPSHOT-jar-with-dependencies.jar \oldest /user/vgonnot/hive/trees.csv /user/vgonnot/oldest1`

` hdfs dfs -cat /user/vgonnot/oldest1/part-r-00000                                     ` 

` 5`
