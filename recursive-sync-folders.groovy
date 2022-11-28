import groovy.io.FileType

src = ${SOURCE}
dest = ${TARGET}
  
def list = []

def dir = new File("/Users/vijayakumar/.jenkins/workspace/sample-groovy")
dir.eachFileRecurse (FileType.FILES) { file ->
  list << file
}

list.each {
  println it.path
}
