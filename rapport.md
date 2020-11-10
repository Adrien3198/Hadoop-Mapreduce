Adrien MICHEL

<br>


<center> 

<!-- omit in toc -->
# TP MapReduce

</center>

- [1. Districts containing trees](#1-districts-containing-trees)
- [2. Show all existing species](#2-show-all-existing-species)
- [3. Number of trees by species](#3-number-of-trees-by-species)
- [4. Maximum height per specie of tree](#4-maximum-height-per-specie-of-tree)
- [5. Sort the trees height from smallest to largest](#5-sort-the-trees-height-from-smallest-to-largest)
- [6. District containing the oldest tree](#6-district-containing-the-oldest-tree)
- [7. District containing the most tree](#7-district-containing-the-most-tree)

<br>

[GitHub link](https://github.com/Adrien3198/Hadoop-Mapreduce)

<!-- omit in toc -->
## Remarkable trees of Paris

### 1. Districts containing trees
TARGET :  *A MapReduce job that displays the list of distinct containing trees in the file.*

- Command
```
[amichel@hadoop-edge01 ~]$ yarn jar hadoop-examples-mapreduce-1.0-SNAPSHOT-jar-with-dependencies.jar districts_list trees.csv districts_list-output
```
- MapReduce trace
```
20/11/10 20:27:30 INFO client.AHSProxy: Connecting to Application History server at hadoop-master03.efrei.online/163.172.100.24:10200
20/11/10 20:27:30 INFO hdfs.DFSClient: Created token for amichel: HDFS_DELEGATION_TOKEN owner=amichel@EFREI.ONLINE, renewer=yarn, realUser=, issueDate=1605036450838, maxDate=1605641250838, sequenceNumber=6055, masterKeyId=46 on ha-hdfs:efrei
20/11/10 20:27:30 INFO security.TokenCache: Got dt for hdfs://efrei; Kind: HDFS_DELEGATION_TOKEN, Service: ha-hdfs:efrei, Ident: (token for amichel: HDFS_DELEGATION_TOKEN owner=amichel@EFREI.ONLINE, renewer=yarn, realUser=, issueDate=1605036450838, maxDate=1605641250838, sequenceNumber=6055, masterKeyId=46)
20/11/10 20:27:30 INFO mapreduce.JobResourceUploader: Disabling Erasure Coding for path: /user/amichel/.staging/job_1603290159664_3591
20/11/10 20:27:31 INFO input.FileInputFormat: Total input files to process : 1
20/11/10 20:27:31 INFO mapreduce.JobSubmitter: number of splits:1
20/11/10 20:27:32 INFO mapreduce.JobSubmitter: Submitting tokens for job: job_1603290159664_3591
20/11/10 20:27:32 INFO mapreduce.JobSubmitter: Executing with tokens: [Kind: HDFS_DELEGATION_TOKEN, Service: ha-hdfs:efrei, Ident: (token for amichel: HDFS_DELEGATION_TOKEN owner=amichel@EFREI.ONLINE, renewer=yarn, realUser=, issueDate=1605036450838, maxDate=1605641250838, sequenceNumber=6055, masterKeyId=46)]
20/11/10 20:27:32 INFO conf.Configuration: found resource resource-types.xml at file:/etc/hadoop/3.1.5.0-152/0/resource-types.xml
20/11/10 20:27:32 INFO impl.TimelineClientImpl: Timeline service address: hadoop-master03.efrei.online:8190
20/11/10 20:27:32 INFO impl.YarnClientImpl: Submitted application application_1603290159664_3591
20/11/10 20:27:32 INFO mapreduce.Job: The url to track the job: https://hadoop-master01.efrei.online:8090/proxy/application_1603290159664_3591/
20/11/10 20:27:32 INFO mapreduce.Job: Running job: job_1603290159664_3591
20/11/10 20:27:43 INFO mapreduce.Job: Job job_1603290159664_3591 running in uber mode : false
20/11/10 20:27:43 INFO mapreduce.Job:  map 0% reduce 0%
20/11/10 20:27:52 INFO mapreduce.Job:  map 100% reduce 0%
20/11/10 20:28:02 INFO mapreduce.Job:  map 100% reduce 100%
20/11/10 20:28:03 INFO mapreduce.Job: Job job_1603290159664_3591 completed successfully
20/11/10 20:28:03 INFO mapreduce.Job: Counters: 53
        File System Counters
                FILE: Number of bytes read=84
                FILE: Number of bytes written=493381
                FILE: Number of read operations=0
                FILE: Number of large read operations=0
                FILE: Number of write operations=0
                HDFS: Number of bytes read=16780
                HDFS: Number of bytes written=44
                HDFS: Number of read operations=8
                HDFS: Number of large read operations=0
                HDFS: Number of write operations=2
        Job Counters 
                Launched map tasks=1
                Launched reduce tasks=1
                Data-local map tasks=1
                Total time spent by all maps in occupied slots (ms)=20979
                Total time spent by all reduces in occupied slots (ms)=28956
                Total time spent by all map tasks (ms)=6993
                Total time spent by all reduce tasks (ms)=7239
                Total vcore-milliseconds taken by all map tasks=6993
                Total vcore-milliseconds taken by all reduce tasks=7239
                Total megabyte-milliseconds taken by all map tasks=10741248
                Total megabyte-milliseconds taken by all reduce tasks=14825472
        Map-Reduce Framework
                Map input records=98
                Map output records=97
                Map output bytes=277
                Map output materialized bytes=84
                Input split bytes=100
                Combine input records=97
                Combine output records=17
                Reduce input groups=17
                Reduce shuffle bytes=84
                Reduce input records=17
                Reduce output records=17
                Spilled Records=34
                Shuffled Maps =1
                Failed Shuffles=0
                Merged Map outputs=1
                GC time elapsed (ms)=205
                CPU time spent (ms)=3870
                Physical memory (bytes) snapshot=1456259072
                Virtual memory (bytes) snapshot=7272656896
                Total committed heap usage (bytes)=1558708224
                Peak Map Physical memory (bytes)=1156468736
                Peak Map Virtual memory (bytes)=3394363392
                Peak Reduce Physical memory (bytes)=299790336
                Peak Reduce Virtual memory (bytes)=3878293504
        Shuffle Errors
                BAD_ID=0
                CONNECTION=0
                IO_ERROR=0
                WRONG_LENGTH=0
                WRONG_MAP=0
                WRONG_REDUCE=0
        File Input Format Counters 
                Bytes Read=16680
        File Output Format Counters 
                Bytes Written=44
```
- MapReduce Output
```
[amichel@hadoop-edge01 ~]$ hdfs dfs -cat districts_list-output/part-r-00000
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

### 2. Show all existing species

TARGET *A MapReduce job that displays the list of different species trees in thisfile.*

- Command
```
[amichel@hadoop-edge01 ~]$ yarn jar hadoop-examples-mapreduce-1.0-SNAPSHOT-jar-with-dependencies.jar species_list trees.csv species_list-output
```
- MapReduce trace
```
20/11/10 20:42:37 INFO client.AHSProxy: Connecting to Application History server at hadoop-master03.efrei.online/163.172.100.24:10200
20/11/10 20:42:37 INFO hdfs.DFSClient: Created token for amichel: HDFS_DELEGATION_TOKEN owner=amichel@EFREI.ONLINE, renewer=yarn, realUser=, issueDate=1605037357590, maxDate=1605642157590, sequenceNumber=6075, masterKeyId=46 on ha-hdfs:efrei
20/11/10 20:42:37 INFO security.TokenCache: Got dt for hdfs://efrei; Kind: HDFS_DELEGATION_TOKEN, Service: ha-hdfs:efrei, Ident: (token for amichel: HDFS_DELEGATION_TOKEN owner=amichel@EFREI.ONLINE, renewer=yarn, realUser=, issueDate=1605037357590, maxDate=1605642157590, sequenceNumber=6075, masterKeyId=46)
20/11/10 20:42:37 INFO mapreduce.JobResourceUploader: Disabling Erasure Coding for path: /user/amichel/.staging/job_1603290159664_3600
20/11/10 20:42:38 INFO input.FileInputFormat: Total input files to process : 1
20/11/10 20:42:38 INFO mapreduce.JobSubmitter: number of splits:1
20/11/10 20:42:38 INFO mapreduce.JobSubmitter: Submitting tokens for job: job_1603290159664_3600
20/11/10 20:42:38 INFO mapreduce.JobSubmitter: Executing with tokens: [Kind: HDFS_DELEGATION_TOKEN, Service: ha-hdfs:efrei, Ident: (token for amichel: HDFS_DELEGATION_TOKEN owner=amichel@EFREI.ONLINE, renewer=yarn, realUser=, issueDate=1605037357590, maxDate=1605642157590, sequenceNumber=6075, masterKeyId=46)]
20/11/10 20:42:38 INFO conf.Configuration: found resource resource-types.xml at file:/etc/hadoop/3.1.5.0-152/0/resource-types.xml
20/11/10 20:42:38 INFO impl.TimelineClientImpl: Timeline service address: hadoop-master03.efrei.online:8190
20/11/10 20:42:39 INFO impl.YarnClientImpl: Submitted application application_1603290159664_3600
20/11/10 20:42:39 INFO mapreduce.Job: The url to track the job: https://hadoop-master01.efrei.online:8090/proxy/application_1603290159664_3600/
20/11/10 20:42:39 INFO mapreduce.Job: Running job: job_1603290159664_3600
20/11/10 20:42:49 INFO mapreduce.Job: Job job_1603290159664_3600 running in uber mode : false
20/11/10 20:42:49 INFO mapreduce.Job:  map 0% reduce 0%
20/11/10 20:42:58 INFO mapreduce.Job:  map 100% reduce 0%
20/11/10 20:43:09 INFO mapreduce.Job:  map 100% reduce 100%
20/11/10 20:43:09 INFO mapreduce.Job: Job job_1603290159664_3600 completed successfully
20/11/10 20:43:09 INFO mapreduce.Job: Counters: 53
        File System Counters
                FILE: Number of bytes read=547
                FILE: Number of bytes written=494289
                FILE: Number of read operations=0
                FILE: Number of large read operations=0
                FILE: Number of write operations=0
                HDFS: Number of bytes read=16780
                HDFS: Number of bytes written=451
                HDFS: Number of read operations=8
                HDFS: Number of large read operations=0
                HDFS: Number of write operations=2
        Job Counters 
                Launched map tasks=1
                Launched reduce tasks=1
                Data-local map tasks=1
                Total time spent by all maps in occupied slots (ms)=21435
                Total time spent by all reduces in occupied slots (ms)=27672
                Total time spent by all map tasks (ms)=7145
                Total time spent by all reduce tasks (ms)=6918
                Total vcore-milliseconds taken by all map tasks=7145
                Total vcore-milliseconds taken by all reduce tasks=6918
                Total megabyte-milliseconds taken by all map tasks=10974720
                Total megabyte-milliseconds taken by all reduce tasks=14168064
        Map-Reduce Framework
                Map input records=98
                Map output records=97
                Map output bytes=995
                Map output materialized bytes=547
                Input split bytes=100
                Combine input records=97
                Combine output records=45
                Reduce input groups=45
                Reduce shuffle bytes=547
                Reduce input records=45
                Reduce output records=45
                Spilled Records=90
                Shuffled Maps =1
                Failed Shuffles=0
                Merged Map outputs=1
                GC time elapsed (ms)=179
                CPU time spent (ms)=3180
                Physical memory (bytes) snapshot=1453232128
                Virtual memory (bytes) snapshot=7272992768
                Total committed heap usage (bytes)=1561853952
                Peak Map Physical memory (bytes)=1159942144
                Peak Map Virtual memory (bytes)=3397566464
                Peak Reduce Physical memory (bytes)=293289984
                Peak Reduce Virtual memory (bytes)=3875426304
        Shuffle Errors
                BAD_ID=0
                CONNECTION=0
                IO_ERROR=0
                WRONG_LENGTH=0
                WRONG_MAP=0
                WRONG_REDUCE=0
        File Input Format Counters 
                Bytes Read=16680
        File Output Format Counters 
                Bytes Written=451
```
- MapReduce Output
```
[amichel@hadoop-edge01 ~]$ hdfs dfs -cat species_list-output/part-r-00000
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
x acerifolia
```

### 3. Number of trees by species

TARGET *A MapReduce job that calculates the number of trees of each species.*

For the reducer, I reuse the reducer of the `wordcount` program.

- Command
```
[amichel@hadoop-edge01 ~]$ yarn jar hadoop-examples-mapreduce-1.0-SNAPSHOT-jar-with-dependencies.jar trees_counter trees.csv trees_counter-output
```
- MapReduce trace
```
20/11/10 20:50:35 INFO client.AHSProxy: Connecting to Application History server at hadoop-master03.efrei.online/163.172.100.24:10200
20/11/10 20:50:36 INFO hdfs.DFSClient: Created token for amichel: HDFS_DELEGATION_TOKEN owner=amichel@EFREI.ONLINE, renewer=yarn, realUser=, issueDate=1605037836074, maxDate=1605642636074, sequenceNumber=6090, masterKeyId=46 on ha-hdfs:efrei
20/11/10 20:50:36 INFO security.TokenCache: Got dt for hdfs://efrei; Kind: HDFS_DELEGATION_TOKEN, Service: ha-hdfs:efrei, Ident: (token for amichel: HDFS_DELEGATION_TOKEN owner=amichel@EFREI.ONLINE, renewer=yarn, realUser=, issueDate=1605037836074, maxDate=1605642636074, sequenceNumber=6090, masterKeyId=46)
20/11/10 20:50:36 INFO mapreduce.JobResourceUploader: Disabling Erasure Coding for path: /user/amichel/.staging/job_1603290159664_3610
20/11/10 20:50:37 INFO input.FileInputFormat: Total input files to process : 1
20/11/10 20:50:37 INFO mapreduce.JobSubmitter: number of splits:1
20/11/10 20:50:37 INFO mapreduce.JobSubmitter: Submitting tokens for job: job_1603290159664_3610
20/11/10 20:50:37 INFO mapreduce.JobSubmitter: Executing with tokens: [Kind: HDFS_DELEGATION_TOKEN, Service: ha-hdfs:efrei, Ident: (token for amichel: HDFS_DELEGATION_TOKEN owner=amichel@EFREI.ONLINE, renewer=yarn, realUser=, issueDate=1605037836074, maxDate=1605642636074, sequenceNumber=6090, masterKeyId=46)]
20/11/10 20:50:37 INFO conf.Configuration: found resource resource-types.xml at file:/etc/hadoop/3.1.5.0-152/0/resource-types.xml
20/11/10 20:50:37 INFO impl.TimelineClientImpl: Timeline service address: hadoop-master03.efrei.online:8190
20/11/10 20:50:37 INFO impl.YarnClientImpl: Submitted application application_1603290159664_3610
20/11/10 20:50:37 INFO mapreduce.Job: The url to track the job: https://hadoop-master01.efrei.online:8090/proxy/application_1603290159664_3610/
20/11/10 20:50:37 INFO mapreduce.Job: Running job: job_1603290159664_3610
20/11/10 20:50:48 INFO mapreduce.Job: Job job_1603290159664_3610 running in uber mode : false
20/11/10 20:50:48 INFO mapreduce.Job:  map 0% reduce 0%
20/11/10 20:50:57 INFO mapreduce.Job:  map 100% reduce 0%
20/11/10 20:51:06 INFO mapreduce.Job:  map 100% reduce 100%
20/11/10 20:51:06 INFO mapreduce.Job: Job job_1603290159664_3610 completed successfully
20/11/10 20:51:06 INFO mapreduce.Job: Counters: 53
        File System Counters
                FILE: Number of bytes read=727
                FILE: Number of bytes written=494633
                FILE: Number of read operations=0
                FILE: Number of large read operations=0
                FILE: Number of write operations=0
                HDFS: Number of bytes read=16780
                HDFS: Number of bytes written=542
                HDFS: Number of read operations=8
                HDFS: Number of large read operations=0
                HDFS: Number of write operations=2
        Job Counters 
                Launched map tasks=1
                Launched reduce tasks=1
                Data-local map tasks=1
                Total time spent by all maps in occupied slots (ms)=20187
                Total time spent by all reduces in occupied slots (ms)=28100
                Total time spent by all map tasks (ms)=6729
                Total time spent by all reduce tasks (ms)=7025
                Total vcore-milliseconds taken by all map tasks=6729
                Total vcore-milliseconds taken by all reduce tasks=7025
                Total megabyte-milliseconds taken by all map tasks=10335744
                Total megabyte-milliseconds taken by all reduce tasks=14387200
        Map-Reduce Framework
                Map input records=98
                Map output records=97
                Map output bytes=1383
                Map output materialized bytes=727
                Input split bytes=100
                Combine input records=97
                Combine output records=45
                Reduce input groups=45
                Reduce shuffle bytes=727
                Reduce input records=45
                Reduce output records=45
                Spilled Records=90
                Shuffled Maps =1
                Failed Shuffles=0
                Merged Map outputs=1
                GC time elapsed (ms)=202
                CPU time spent (ms)=3040
                Physical memory (bytes) snapshot=1451823104
                Virtual memory (bytes) snapshot=7270031360
                Total committed heap usage (bytes)=1550843904
                Peak Map Physical memory (bytes)=1156247552
                Peak Map Virtual memory (bytes)=3392073728
                Peak Reduce Physical memory (bytes)=295575552
                Peak Reduce Virtual memory (bytes)=3877957632
        Shuffle Errors
                BAD_ID=0
                CONNECTION=0
                IO_ERROR=0
                WRONG_LENGTH=0
                WRONG_MAP=0
                WRONG_REDUCE=0
        File Input Format Counters 
                Bytes Read=16680
        File Output Format Counters 
                Bytes Written=542
```
- MapReduce 0utput
```
[amichel@hadoop-edge01 ~]$ hdfs dfs -cat trees_counter-output/part-r-00000
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

### 4. Maximum height per specie of tree

TARGET *A MapReduce job that calculates the height of the tallest tree of each kind.*

- Command
```
[amichel@hadoop-edge01 ~]$ yarn jar hadoop-examples-mapreduce-1.0-SNAPSHOT-jar-with-dependencies.jar max_height trees.csv max_height-output
```
- MapReduce trace
```
20/11/10 20:54:27 INFO client.AHSProxy: Connecting to Application History server at hadoop-master03.efrei.online/163.172.100.24:10200
20/11/10 20:54:27 INFO hdfs.DFSClient: Created token for amichel: HDFS_DELEGATION_TOKEN owner=amichel@EFREI.ONLINE, renewer=yarn, realUser=, issueDate=1605038067916, maxDate=1605642867916, sequenceNumber=6095, masterKeyId=46 on ha-hdfs:efrei
20/11/10 20:54:27 INFO security.TokenCache: Got dt for hdfs://efrei; Kind: HDFS_DELEGATION_TOKEN, Service: ha-hdfs:efrei, Ident: (token for amichel: HDFS_DELEGATION_TOKEN owner=amichel@EFREI.ONLINE, renewer=yarn, realUser=, issueDate=1605038067916, maxDate=1605642867916, sequenceNumber=6095, masterKeyId=46)
20/11/10 20:54:28 INFO mapreduce.JobResourceUploader: Disabling Erasure Coding for path: /user/amichel/.staging/job_1603290159664_3614
20/11/10 20:54:28 INFO input.FileInputFormat: Total input files to process : 1
20/11/10 20:54:28 INFO mapreduce.JobSubmitter: number of splits:1
20/11/10 20:54:29 INFO mapreduce.JobSubmitter: Submitting tokens for job: job_1603290159664_3614
20/11/10 20:54:29 INFO mapreduce.JobSubmitter: Executing with tokens: [Kind: HDFS_DELEGATION_TOKEN, Service: ha-hdfs:efrei, Ident: (token for amichel: HDFS_DELEGATION_TOKEN owner=amichel@EFREI.ONLINE, renewer=yarn, realUser=, issueDate=1605038067916, maxDate=1605642867916, sequenceNumber=6095, masterKeyId=46)]
20/11/10 20:54:29 INFO conf.Configuration: found resource resource-types.xml at file:/etc/hadoop/3.1.5.0-152/0/resource-types.xml
20/11/10 20:54:29 INFO impl.TimelineClientImpl: Timeline service address: hadoop-master03.efrei.online:8190
20/11/10 20:54:29 INFO impl.YarnClientImpl: Submitted application application_1603290159664_3614
20/11/10 20:54:29 INFO mapreduce.Job: The url to track the job: https://hadoop-master01.efrei.online:8090/proxy/application_1603290159664_3614/
20/11/10 20:54:29 INFO mapreduce.Job: Running job: job_1603290159664_3614
20/11/10 20:54:40 INFO mapreduce.Job: Job job_1603290159664_3614 running in uber mode : false
20/11/10 20:54:40 INFO mapreduce.Job:  map 0% reduce 0%
20/11/10 20:54:49 INFO mapreduce.Job:  map 100% reduce 0%
20/11/10 20:54:59 INFO mapreduce.Job:  map 100% reduce 100%
20/11/10 20:55:00 INFO mapreduce.Job: Job job_1603290159664_3614 completed successfully
20/11/10 20:55:00 INFO mapreduce.Job: Counters: 53
        File System Counters
                FILE: Number of bytes read=907
                FILE: Number of bytes written=494993
                FILE: Number of read operations=0
                FILE: Number of large read operations=0
                FILE: Number of write operations=0
                HDFS: Number of bytes read=16780
                HDFS: Number of bytes written=675
                HDFS: Number of read operations=8
                HDFS: Number of large read operations=0
                HDFS: Number of write operations=2
        Job Counters 
                Launched map tasks=1
                Launched reduce tasks=1
                Data-local map tasks=1
                Total time spent by all maps in occupied slots (ms)=21141
                Total time spent by all reduces in occupied slots (ms)=28124
                Total time spent by all map tasks (ms)=7047
                Total time spent by all reduce tasks (ms)=7031
                Total vcore-milliseconds taken by all map tasks=7047
                Total vcore-milliseconds taken by all reduce tasks=7031
                Total megabyte-milliseconds taken by all map tasks=10824192
                Total megabyte-milliseconds taken by all reduce tasks=14399488
        Map-Reduce Framework
                Map input records=98
                Map output records=96
                Map output bytes=1753
                Map output materialized bytes=907
                Input split bytes=100
                Combine input records=96
                Combine output records=45
                Reduce input groups=45
                Reduce shuffle bytes=907
                Reduce input records=45
                Reduce output records=45
                Spilled Records=90
                Shuffled Maps =1
                Failed Shuffles=0
                Merged Map outputs=1
                GC time elapsed (ms)=197
                CPU time spent (ms)=3440
                Physical memory (bytes) snapshot=1459666944
                Virtual memory (bytes) snapshot=7281717248
                Total committed heap usage (bytes)=1564999680
                Peak Map Physical memory (bytes)=1157283840
                Peak Map Virtual memory (bytes)=3394998272
                Peak Reduce Physical memory (bytes)=302383104
                Peak Reduce Virtual memory (bytes)=3886718976
        Shuffle Errors
                BAD_ID=0
                CONNECTION=0
                IO_ERROR=0
                WRONG_LENGTH=0
                WRONG_MAP=0
                WRONG_REDUCE=0
        File Input Format Counters 
                Bytes Read=16680
        File Output Format Counters 
                Bytes Written=675
```
- MapReduce 0utput
```
[amichel@hadoop-edge01 ~]$ hdfs dfs -cat max_height-output/part-r-00000
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

### 5. Sort the trees height from smallest to largest

TARGET *A MapReduce job that sort the trees height from smallest to largest.*

- Command
```
[amichel@hadoop-edge01 ~]$ yarn jar hadoop-examples-mapreduce-1.0-SNAPSHOT-jar-with-dependencies.jar sort_trees trees.csv sort_trees-output
``` 
- MapReduce trace
```
20/11/10 20:57:28 INFO client.AHSProxy: Connecting to Application History server at hadoop-master03.efrei.online/163.172.100.24:10200
20/11/10 20:57:28 INFO hdfs.DFSClient: Created token for amichel: HDFS_DELEGATION_TOKEN owner=amichel@EFREI.ONLINE, renewer=yarn, realUser=, issueDate=1605038248355, maxDate=1605643048355, sequenceNumber=6099, masterKeyId=46 on ha-hdfs:efrei
20/11/10 20:57:28 INFO security.TokenCache: Got dt for hdfs://efrei; Kind: HDFS_DELEGATION_TOKEN, Service: ha-hdfs:efrei, Ident: (token for amichel: HDFS_DELEGATION_TOKEN owner=amichel@EFREI.ONLINE, renewer=yarn, realUser=, issueDate=1605038248355, maxDate=1605643048355, sequenceNumber=6099, masterKeyId=46)
20/11/10 20:57:28 INFO mapreduce.JobResourceUploader: Disabling Erasure Coding for path: /user/amichel/.staging/job_1603290159664_3616
20/11/10 20:57:29 INFO input.FileInputFormat: Total input files to process : 1
20/11/10 20:57:29 INFO mapreduce.JobSubmitter: number of splits:1
20/11/10 20:57:29 INFO mapreduce.JobSubmitter: Submitting tokens for job: job_1603290159664_3616
20/11/10 20:57:29 INFO mapreduce.JobSubmitter: Executing with tokens: [Kind: HDFS_DELEGATION_TOKEN, Service: ha-hdfs:efrei, Ident: (token for amichel: HDFS_DELEGATION_TOKEN owner=amichel@EFREI.ONLINE, renewer=yarn, realUser=, issueDate=1605038248355, maxDate=1605643048355, sequenceNumber=6099, masterKeyId=46)]
20/11/10 20:57:29 INFO conf.Configuration: found resource resource-types.xml at file:/etc/hadoop/3.1.5.0-152/0/resource-types.xml
20/11/10 20:57:29 INFO impl.TimelineClientImpl: Timeline service address: hadoop-master03.efrei.online:8190
20/11/10 20:57:30 INFO impl.YarnClientImpl: Submitted application application_1603290159664_3616
20/11/10 20:57:30 INFO mapreduce.Job: The url to track the job: https://hadoop-master01.efrei.online:8090/proxy/application_1603290159664_3616/
20/11/10 20:57:30 INFO mapreduce.Job: Running job: job_1603290159664_3616
20/11/10 20:57:40 INFO mapreduce.Job: Job job_1603290159664_3616 running in uber mode : false
20/11/10 20:57:40 INFO mapreduce.Job:  map 0% reduce 0%
20/11/10 20:57:49 INFO mapreduce.Job:  map 100% reduce 0%
20/11/10 20:57:55 INFO mapreduce.Job:  map 100% reduce 100%
20/11/10 20:57:55 INFO mapreduce.Job: Job job_1603290159664_3616 completed successfully
20/11/10 20:57:55 INFO mapreduce.Job: Counters: 53
        File System Counters
                FILE: Number of bytes read=966
                FILE: Number of bytes written=495121
                FILE: Number of read operations=0
                FILE: Number of large read operations=0
                FILE: Number of write operations=0
                HDFS: Number of bytes read=16780
                HDFS: Number of bytes written=476
                HDFS: Number of read operations=8
                HDFS: Number of large read operations=0
                HDFS: Number of write operations=2
        Job Counters 
                Launched map tasks=1
                Launched reduce tasks=1
                Data-local map tasks=1
                Total time spent by all maps in occupied slots (ms)=20568
                Total time spent by all reduces in occupied slots (ms)=11936
                Total time spent by all map tasks (ms)=6856
                Total time spent by all reduce tasks (ms)=2984
                Total vcore-milliseconds taken by all map tasks=6856
                Total vcore-milliseconds taken by all reduce tasks=2984
                Total megabyte-milliseconds taken by all map tasks=10530816
                Total megabyte-milliseconds taken by all reduce tasks=6111232
        Map-Reduce Framework
                Map input records=98
                Map output records=96
                Map output bytes=768
                Map output materialized bytes=966
                Input split bytes=100
                Combine input records=96
                Combine output records=96
                Reduce input groups=28
                Reduce shuffle bytes=966
                Reduce input records=96
                Reduce output records=96
                Spilled Records=192
                Shuffled Maps =1
                Failed Shuffles=0
                Merged Map outputs=1
                GC time elapsed (ms)=189
                CPU time spent (ms)=3370
                Physical memory (bytes) snapshot=1445679104
                Virtual memory (bytes) snapshot=7268802560
                Total committed heap usage (bytes)=1552941056
                Peak Map Physical memory (bytes)=1152315392
                Peak Map Virtual memory (bytes)=3394564096
                Peak Reduce Physical memory (bytes)=293363712
                Peak Reduce Virtual memory (bytes)=3874238464
        Shuffle Errors
                BAD_ID=0
                CONNECTION=0
                IO_ERROR=0
                WRONG_LENGTH=0
                WRONG_MAP=0
                WRONG_REDUCE=0
        File Input Format Counters 
                Bytes Read=16680
        File Output Format Counters 
                Bytes Written=476

```
- MapReduce 0utput
```
[amichel@hadoop-edge01 ~]$ hdfs dfs -cat sort_trees-output/part-r-00000
2.0
5.0
6.0
9.0
10.0
10.0
10.0
10.0
10.0
11.0
12.0
12.0
12.0
12.0
12.0
12.0
12.0
12.0
13.0
13.0
14.0
14.0
14.0
15.0
15.0
15.0
15.0
15.0
16.0
16.0
16.0
16.0
18.0
18.0
18.0
18.0
20.0
20.0
20.0
20.0
20.0
20.0
20.0
20.0
20.0
20.0
20.0
20.0
22.0
22.0
22.0
22.0
22.0
23.0
25.0
25.0
25.0
25.0
25.0
25.0
26.0
27.0
27.0
28.0
30.0
30.0
30.0
30.0
30.0
30.0
30.0
30.0
30.0
30.0
30.0
30.0
30.0
30.0
30.0
30.0
30.0
31.0
31.0
32.0
33.0
34.0
35.0
35.0
35.0
35.0
35.0
40.0
40.0
40.0
42.0
45.0
```

### 6. District containing the oldest tree

TARGET *A MapReduce job that displays the district where the oldest tree is*

I defined a subclass of Writable `IntStringWritable` to contain both age (`int`) and district (`String`)

- Command
```
[amichel@hadoop-edge01 ~]$ yarn jar hadoop-examples-mapreduce-1.0-SNAPSHOT-jar-with-dependencies.jar oldest_tree trees.csv oldest_tree-output
``` 
- MapReduce trace
```
20/11/10 21:00:49 INFO client.AHSProxy: Connecting to Application History server at hadoop-master03.efrei.online/163.172.100.24:10200
20/11/10 21:00:49 INFO hdfs.DFSClient: Created token for amichel: HDFS_DELEGATION_TOKEN owner=amichel@EFREI.ONLINE, renewer=yarn, realUser=, issueDate=1605038449615, maxDate=1605643249615, sequenceNumber=6102, masterKeyId=46 on ha-hdfs:efrei
20/11/10 21:00:49 INFO security.TokenCache: Got dt for hdfs://efrei; Kind: HDFS_DELEGATION_TOKEN, Service: ha-hdfs:efrei, Ident: (token for amichel: HDFS_DELEGATION_TOKEN owner=amichel@EFREI.ONLINE, renewer=yarn, realUser=, issueDate=1605038449615, maxDate=1605643249615, sequenceNumber=6102, masterKeyId=46)
20/11/10 21:00:49 INFO mapreduce.JobResourceUploader: Disabling Erasure Coding for path: /user/amichel/.staging/job_1603290159664_3618
20/11/10 21:00:50 INFO input.FileInputFormat: Total input files to process : 1
20/11/10 21:00:50 INFO mapreduce.JobSubmitter: number of splits:1
20/11/10 21:00:50 INFO mapreduce.JobSubmitter: Submitting tokens for job: job_1603290159664_3618
20/11/10 21:00:50 INFO mapreduce.JobSubmitter: Executing with tokens: [Kind: HDFS_DELEGATION_TOKEN, Service: ha-hdfs:efrei, Ident: (token for amichel: HDFS_DELEGATION_TOKEN owner=amichel@EFREI.ONLINE, renewer=yarn, realUser=, issueDate=1605038449615, maxDate=1605643249615, sequenceNumber=6102, masterKeyId=46)]
20/11/10 21:00:51 INFO conf.Configuration: found resource resource-types.xml at file:/etc/hadoop/3.1.5.0-152/0/resource-types.xml
20/11/10 21:00:51 INFO impl.TimelineClientImpl: Timeline service address: hadoop-master03.efrei.online:8190
20/11/10 21:00:51 INFO impl.YarnClientImpl: Submitted application application_1603290159664_3618
20/11/10 21:00:51 INFO mapreduce.Job: The url to track the job: https://hadoop-master01.efrei.online:8090/proxy/application_1603290159664_3618/
20/11/10 21:00:51 INFO mapreduce.Job: Running job: job_1603290159664_3618
20/11/10 21:01:01 INFO mapreduce.Job: Job job_1603290159664_3618 running in uber mode : false
20/11/10 21:01:01 INFO mapreduce.Job:  map 0% reduce 0%
20/11/10 21:01:10 INFO mapreduce.Job:  map 100% reduce 0%
20/11/10 21:01:16 INFO mapreduce.Job:  map 100% reduce 100%
20/11/10 21:01:17 INFO mapreduce.Job: Job job_1603290159664_3618 completed successfully
20/11/10 21:01:17 INFO mapreduce.Job: Counters: 53
        File System Counters
                FILE: Number of bytes read=752
                FILE: Number of bytes written=494295
                FILE: Number of read operations=0
                FILE: Number of large read operations=0
                FILE: Number of write operations=0
                HDFS: Number of bytes read=16780
                HDFS: Number of bytes written=3
                HDFS: Number of read operations=8
                HDFS: Number of large read operations=0
                HDFS: Number of write operations=2
        Job Counters 
                Launched map tasks=1
                Launched reduce tasks=1
                Data-local map tasks=1
                Total time spent by all maps in occupied slots (ms)=19764
                Total time spent by all reduces in occupied slots (ms)=12684
                Total time spent by all map tasks (ms)=6588
                Total time spent by all reduce tasks (ms)=3171
                Total vcore-milliseconds taken by all map tasks=6588
                Total vcore-milliseconds taken by all reduce tasks=3171
                Total megabyte-milliseconds taken by all map tasks=10119168
                Total megabyte-milliseconds taken by all reduce tasks=6494208
        Map-Reduce Framework
                Map input records=98
                Map output records=77
                Map output bytes=592
                Map output materialized bytes=752
                Input split bytes=100
                Combine input records=0
                Combine output records=0
                Reduce input groups=1
                Reduce shuffle bytes=752
                Reduce input records=77
                Reduce output records=1
                Spilled Records=154
                Shuffled Maps =1
                Failed Shuffles=0
                Merged Map outputs=1
                GC time elapsed (ms)=170
                CPU time spent (ms)=3140
                Physical memory (bytes) snapshot=1454387200
                Virtual memory (bytes) snapshot=7272169472
                Total committed heap usage (bytes)=1544028160
                Peak Map Physical memory (bytes)=1156542464
                Peak Map Virtual memory (bytes)=3396116480
                Peak Reduce Physical memory (bytes)=297844736
                Peak Reduce Virtual memory (bytes)=3876052992
        Shuffle Errors
                BAD_ID=0
                CONNECTION=0
                IO_ERROR=0
                WRONG_LENGTH=0
                WRONG_MAP=0
                WRONG_REDUCE=0
        File Input Format Counters 
                Bytes Read=16680
        File Output Format Counters 
                Bytes Written=3
```
- MapReduce 0utput
```
[amichel@hadoop-edge01 ~]$ hdfs dfs -cat oldest_tree-output/part-r-00000
5
```

### 7. District containing the most tree

TARGET *A  MapReduce job that displays the district that contains the most trees*

I also use the class `IntStringWritable` to contain both number of trees and district in the second MapReduce job.

For the reducer of the first job, I reuse the reducer of `trees_counter` program.

- Command
```
[amichel@hadoop-edge01 ~]$ yarn jar hadoop-examples-mapreduce-1.0-SNAPSHOT-jar-with-dependencies.jar most_trees trees.csv most_trees-output
``` 
- First MapReduce trace
```
dfs:efrei
20/11/10 21:15:15 INFO security.TokenCache: Got dt for hdfs://efrei; Kind: HDFS_DELEGATION_TOKEN, Service: ha-hdfs:efrei, Ident: (token for amichel: HDFS_DELEGATION_TOKEN owner=amichel@EFREI.ONLINE, renewer=yarn, realUser=, issueDate=1605039315359, maxDate=1605644115359, sequenceNumber=6109, masterKeyId=46)
20/11/10 21:15:15 INFO mapreduce.JobResourceUploader: Disabling Erasure Coding for path: /user/amichel/.staging/job_1603290159664_3623
20/11/10 21:15:16 INFO input.FileInputFormat: Total input files to process : 1
20/11/10 21:15:16 INFO mapreduce.JobSubmitter: number of splits:1
20/11/10 21:15:16 INFO mapreduce.JobSubmitter: Submitting tokens for job: job_1603290159664_3623
20/11/10 21:15:16 INFO mapreduce.JobSubmitter: Executing with tokens: [Kind: HDFS_DELEGATION_TOKEN, Service: ha-hdfs:efrei, Ident: (token for amichel: HDFS_DELEGATION_TOKEN owner=amichel@EFREI.ONLINE, renewer=yarn, realUser=, issueDate=1605039315359, maxDate=1605644115359, sequenceNumber=6109, masterKeyId=46)]
20/11/10 21:15:16 INFO conf.Configuration: found resource resource-types.xml at file:/etc/hadoop/3.1.5.0-152/0/resource-types.xml
20/11/10 21:15:16 INFO impl.TimelineClientImpl: Timeline service address: hadoop-master03.efrei.online:8190
20/11/10 21:15:17 INFO impl.YarnClientImpl: Submitted application application_1603290159664_3623
20/11/10 21:15:17 INFO mapreduce.Job: The url to track the job: https://hadoop-master01.efrei.online:8090/proxy/application_1603290159664_3623/
20/11/10 21:15:17 INFO mapreduce.Job: Running job: job_1603290159664_3623
20/11/10 21:15:27 INFO mapreduce.Job: Job job_1603290159664_3623 running in uber mode : false
20/11/10 21:15:27 INFO mapreduce.Job:  map 0% reduce 0%
20/11/10 21:15:36 INFO mapreduce.Job:  map 100% reduce 0%
20/11/10 21:15:46 INFO mapreduce.Job:  map 100% reduce 100%
20/11/10 21:15:46 INFO mapreduce.Job: Job job_1603290159664_3623 completed successfully
20/11/10 21:15:46 INFO mapreduce.Job: Counters: 53
        File System Counters
                FILE: Number of bytes read=152
                FILE: Number of bytes written=493519
                FILE: Number of read operations=0
                FILE: Number of large read operations=0
                FILE: Number of write operations=0
                HDFS: Number of bytes read=16780
                HDFS: Number of bytes written=80
                HDFS: Number of read operations=8
                HDFS: Number of large read operations=0
                HDFS: Number of write operations=2
        Job Counters 
                Launched map tasks=1
                Launched reduce tasks=1
                Data-local map tasks=1
                Total time spent by all maps in occupied slots (ms)=21243
                Total time spent by all reduces in occupied slots (ms)=27716
                Total time spent by all map tasks (ms)=7081
                Total time spent by all reduce tasks (ms)=6929
                Total vcore-milliseconds taken by all map tasks=7081
                Total vcore-milliseconds taken by all reduce tasks=6929
                Total megabyte-milliseconds taken by all map tasks=10876416
                Total megabyte-milliseconds taken by all reduce tasks=14190592
        Map-Reduce Framework
                Map input records=98
                Map output records=97
                Map output bytes=665
                Map output materialized bytes=152
                Input split bytes=100
                Combine input records=97
                Combine output records=17
                Reduce input groups=17
                Reduce shuffle bytes=152
                Reduce input records=17
                Reduce output records=17
                Spilled Records=34
                Shuffled Maps =1
                Failed Shuffles=0
                Merged Map outputs=1
                GC time elapsed (ms)=201
                CPU time spent (ms)=3110
                Physical memory (bytes) snapshot=1449189376
                Virtual memory (bytes) snapshot=7268941824
                Total committed heap usage (bytes)=1561853952
                Peak Map Physical memory (bytes)=1158115328
                Peak Map Virtual memory (bytes)=3394150400
                Peak Reduce Physical memory (bytes)=291074048
                Peak Reduce Virtual memory (bytes)=3874791424
        Shuffle Errors
                BAD_ID=0
                CONNECTION=0
                IO_ERROR=0
                WRONG_LENGTH=0
                WRONG_MAP=0
                WRONG_REDUCE=0
        File Input Format Counters 
                Bytes Read=16680
        File Output Format Counters 
                Bytes Written=80
```
- First MapReduce Output
```
[amichel@hadoop-edge01 ~]$ hdfs dfs -cat most_trees-output/out1/part-r-00000
11      1
12      29
13      2
14      3
15      1
16      36
17      1
18      1
19      6
20      3
3       1
4       1
5       2
6       1
7       3
8       5
9       1
```
- Second MapReduce trace
```
20/11/10 21:15:46 INFO client.AHSProxy: Connecting to Application History server at hadoop-master03.efrei.online/163.172.100.24:10200
20/11/10 21:15:46 INFO hdfs.DFSClient: Created token for amichel: HDFS_DELEGATION_TOKEN owner=amichel@EFREI.ONLINE, renewer=yarn, realUser=, issueDate=1605039346820, maxDate=1605644146820, sequenceNumber=6111, masterKeyId=46 on ha-hdfs:efrei
20/11/10 21:15:46 INFO security.TokenCache: Got dt for hdfs://efrei; Kind: HDFS_DELEGATION_TOKEN, Service: ha-hdfs:efrei, Ident: (token for amichel: HDFS_DELEGATION_TOKEN owner=amichel@EFREI.ONLINE, renewer=yarn, realUser=, issueDate=1605039346820, maxDate=1605644146820, sequenceNumber=6111, masterKeyId=46)
20/11/10 21:15:46 WARN mapreduce.JobResourceUploader: Hadoop command-line option parsing not performed. Implement the Tool interface and execute your application with ToolRunner to remedy this.
20/11/10 21:15:46 INFO mapreduce.JobResourceUploader: Disabling Erasure Coding for path: /user/amichel/.staging/job_1603290159664_3624
20/11/10 21:15:47 INFO input.FileInputFormat: Total input files to process : 1
20/11/10 21:15:47 INFO mapreduce.JobSubmitter: number of splits:1
20/11/10 21:15:47 INFO mapreduce.JobSubmitter: Submitting tokens for job: job_1603290159664_3624
20/11/10 21:15:47 INFO mapreduce.JobSubmitter: Executing with tokens: [Kind: HDFS_DELEGATION_TOKEN, Service: ha-hdfs:efrei, Ident: (token for amichel: HDFS_DELEGATION_TOKEN owner=amichel@EFREI.ONLINE, renewer=yarn, realUser=, issueDate=1605039346820, maxDate=1605644146820, sequenceNumber=6111, masterKeyId=46)]
20/11/10 21:15:47 INFO impl.TimelineClientImpl: Timeline service address: hadoop-master03.efrei.online:8190
20/11/10 21:15:47 INFO impl.YarnClientImpl: Submitted application application_1603290159664_3624
20/11/10 21:15:47 INFO mapreduce.Job: The url to track the job: https://hadoop-master01.efrei.online:8090/proxy/application_1603290159664_3624/
20/11/10 21:15:47 INFO mapreduce.Job: Running job: job_1603290159664_3624
20/11/10 21:15:59 INFO mapreduce.Job: Job job_1603290159664_3624 running in uber mode : false
20/11/10 21:15:59 INFO mapreduce.Job:  map 0% reduce 0%
20/11/10 21:16:07 INFO mapreduce.Job:  map 100% reduce 0%
20/11/10 21:16:17 INFO mapreduce.Job:  map 100% reduce 100%
20/11/10 21:16:17 INFO mapreduce.Job: Job job_1603290159664_3624 completed successfully
20/11/10 21:16:17 INFO mapreduce.Job: Counters: 53
        File System Counters
                FILE: Number of bytes read=162
                FILE: Number of bytes written=492859
                FILE: Number of read operations=0
                FILE: Number of large read operations=0
                FILE: Number of write operations=0
                HDFS: Number of bytes read=206
                HDFS: Number of bytes written=8
                HDFS: Number of read operations=8
                HDFS: Number of large read operations=0
                HDFS: Number of write operations=2
        Job Counters 
                Launched map tasks=1
                Launched reduce tasks=1
                Data-local map tasks=1
                Total time spent by all maps in occupied slots (ms)=20379
                Total time spent by all reduces in occupied slots (ms)=28744
                Total time spent by all map tasks (ms)=6793
                Total time spent by all reduce tasks (ms)=7186
                Total vcore-milliseconds taken by all map tasks=6793
                Total vcore-milliseconds taken by all reduce tasks=7186
                Total megabyte-milliseconds taken by all map tasks=10434048
                Total megabyte-milliseconds taken by all reduce tasks=14716928
        Map-Reduce Framework
                Map input records=17
                Map output records=17
                Map output bytes=122
                Map output materialized bytes=162
                Input split bytes=126
                Combine input records=0
                Combine output records=0
                Reduce input groups=1
                Reduce shuffle bytes=162
                Reduce input records=17
                Reduce output records=1
                Spilled Records=34
                Shuffled Maps =1
                Failed Shuffles=0
                Merged Map outputs=1
                GC time elapsed (ms)=202
                CPU time spent (ms)=3120
                Physical memory (bytes) snapshot=1453400064
                Virtual memory (bytes) snapshot=7269408768
                Total committed heap usage (bytes)=1558183936
                Peak Map Physical memory (bytes)=1159172096
                Peak Map Virtual memory (bytes)=3394428928
                Peak Reduce Physical memory (bytes)=294227968
                Peak Reduce Virtual memory (bytes)=3874979840
        Shuffle Errors
                BAD_ID=0
                CONNECTION=0
                IO_ERROR=0
                WRONG_LENGTH=0
                WRONG_MAP=0
                WRONG_REDUCE=0
        File Input Format Counters 
                Bytes Read=80
        File Output Format Counters 
                Bytes Written=8
```
- Second and final MapReduce 0utput
```
[amichel@hadoop-edge01 ~]$ hdfs dfs -cat most_trees-output/final-output/part-r-00000
16      36
```