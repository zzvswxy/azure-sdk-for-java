$repoRoot = Resolve-Path "${PSScriptRoot}..\..\.."
$inputDir = Join-Path ${PSScriptRoot} "inputdir"
$outputDir = Join-Path ${PSScriptRoot} "outputdir"
$versionClientFileName = "version_client.txt"
$pomFileName = "pom.xml"
$defaultVersionClientFilePath = Join-Path $inputDir $versionClientFileName
$defaultPomFilePath = Join-Path $inputDir $pomFileName
$versionClientFilePath = Join-Path $repoRoot "eng" "versioning" $versionClientFileName
$bomPomFilePath = Join-Path $repoRoot "sdk" "boms" "azure-sdk-bom" $pomFileName

if(! (Test-Path $inputDir)) { 
  New-Item -Path $PSScriptRoot -Name "inputdir" -ItemType "directory"
}

if(! (Test-Path $defaultVersionClientFilePath)) {
 Copy-Item $versionClientFilePath -Destination $inputdir
}

if(! (Test-Path $defaultPomFilePath)) {
 Copy-Item $bomPomFilePath -Destination $inputdir
}

$mvnResults = mvn install
$mvnResults = "mvn exec:java -Dexec.args=`"-inputdir=$inputdir -outputdir=$outputdir -mode=generate`""