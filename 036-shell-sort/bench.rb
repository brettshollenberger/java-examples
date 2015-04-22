#!/usr/bin/env ruby

require "rake"
require "pry"

def read_files(glob)
  `ls #{glob}`.split("\n").sort_by do |file|
    str_to_int(file)
  end
end

def str_to_int(str)
  str.split(/\D/).reject { |d| d.empty? }.join("").to_i
end

benchfiles = read_files("bench/*.bench")

benchfiles.each do |benchfile|
  sh "cat #{benchfile} | java Main"
end
