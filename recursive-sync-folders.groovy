import groovy.io.FileType
import groovy.transform.Field


@Field String[] args = binding.getVariable('args') as String[]

def src = args[0]
def dest =  args[1]

def srclist = []
def destlist = []

def srcdir = new File("${src}")
def destdir = new File("${dest}")
srcdir.eachFileRecurse (FileType.FILES) { file ->
  srclist << file
}
destdir.eachFileRecurse (FileType.FILES) { file ->
  destlist << file
}
println("source files")
srclist.each {
  println it.path
}
println("dest files")
destdir.each {
  println it.path
}
