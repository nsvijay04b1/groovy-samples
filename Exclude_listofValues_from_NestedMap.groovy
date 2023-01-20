
/** Here's an example of Groovy code that creates a list of maps and excludes any maps whose value matches a value of a specific list:

Copy code
def maps = [    [key1: 'value1', key2: 'value2'],
    [key3: 'value3', key4: 'value4'],
    [key5: 'value5', key6: 'value6']
]

def excludeList = ['value1', 'value3']

def filteredMaps = maps.findAll { map -> !map.values().find { value -> excludeList.contains(value) } }
In this example, the maps variable is a list of maps, and the excludeList variable is a list of values to be excluded. The findAll method is used to iterate over the list of maps and filter out any maps whose value is found in the excludeList. The resulting list of maps is stored in the filteredMaps variable.

You can also use map.findAll{!excludeList.contains(it.value)} to get the same result.
  
 */

def config = [
     includeList: [ docker : [ [name: 'name1', url: 'url1', image: "image1"],[name: 'name2', url: 'url2', image: "image2"],[name: 'name3', url: 'url3', image: "image3"] ], raw : [[name: 'raw1', url: 'url11', image: "image11"],[name: 'raw2', url: 'url22', image: "image22"],[name: 'raw3', url: 'url33', image: "image33"] ] ],
     excludeList: [ docker : [ 'name1','name8' ], raw : [ 'raw1','raw8' ] ]
]


def resMap = [ taskList : [:] ]
println resMap
config.includeList.each { k,v ->
                // resMap.taskList["$k"] = [:]
                 println k
                 println v
                 println  config.excludeList."$k"
                 resMap.taskList["$k"] = v.findAll { map -> !map.values().find { config.excludeList."$k".contains(it) } }
                 println resMap.taskList["$k"]

}

println resMap






