import groovy.io.FileType
import groovy.transform.Field

@Field String[] args = binding.getVariable('args') as String[]

def src = args[0]
def dest =  args[1]

def list = []

def dir = new File("/Users/vijayakumar/.jenkins/workspace/sample-groovy")
dir.eachFileRecurse (FileType.FILES) { file ->
  list << file
}

list.each {
  println it.path
}
