mv website website-old
grails create-app website
cd website
mv ../website-old/.git .
git checkout README.md
grails create-domain-class Sample
# add 3 properties to Sample.groovy     String prop1, Integer prop2, Date prop3
git checkout grails-app/domain/website/Sample.groovy
grails generate-controller website.Sample 
grails generate-views website.Sample 
grails install-templates
git checkout setup.sh 
