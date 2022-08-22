#!/bin/bash
#安装tree命令软件包
function beforeCreateTreeMD() {
    apt-get install tree
}
#为当前目录中的所有子模块创建tree.md文件
function createTreeMDForChildDir() {
    for item in `ls $1`
    do
    fileName=$item
    if [ -d $fileName ]
    then
	#删除旧的tree.md文件
	rm -rf $fileName/tree.md
	#创建新的tree.md文件
	tree $fileName > $fileName/tree.md
    fi
    done
}
#为当前目录创建tree.md文件
function createTreeMDForCurrentDir(){
    #删除旧的tree.md文件
    rm -rf tree.md
    #创建新的tree.md文件
    tree > tree.md
}
#替换当前目录下tree.md第一行.为当为文件夹名称
function replaceDotToBaseDirName(){
     #替换当前文件夹下tree.md文件的第一行的.为当前文件夹名称	
     sed -i "1,/./c\springcloud-eureka" tree.md
}
function createTreeMD(){
    beforeCreateTreeMD
    createTreeMDForChildDir
    createTreeMDForCurrentDir
    replaceDotToBaseDirName
}

createTreeMD
