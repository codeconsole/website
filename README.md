Demonstrates the differences between 2 websites created with
```
mv website website-old
grails create-app website
cd website
mv ../website-old/.git .
mv ../website-old/README.md .
grails create-domain-class Sample
# add 3 properties to Sample.groovy     String prop1, Integer prop2, Date prop3
mv ../website-old/grails-app/domain/website/Sample.groovy grails-app/domain/website 
grails generate-controller website.Sample 
grails generate-views website.Sample 
grails install-templates 


git commit -a -m <version>
git tag <version>
git push origin --tags
```

Run the wrapper with Live Reloading
```
git clone --single-branch -b 7.0.0-SNAPSHOT https://github.com/codeconsole/website.git website7 && cd website7 && sdk env install && ./hotswapSetup.sh && ./grailsw
```