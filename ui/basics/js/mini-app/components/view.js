// ES6 export syntax, a file can have as many non-default exports as needed
export function ViewComponent(viewName) {

    let html = '';
    let fragment = `components/${viewName}/${viewName}`;

    this.viewMetadata = {
        name: viewName,
        url: `/${viewName}`,
        templateUrl: `${fragment}.html`,
        stylesUrl: `${fragment}.css`
    }

    this.injectTemplate = function(cb) {
        if (html) {
            console.log(`HTML for ${viewName} already fetched, reusing stored data.`);
            document.getElementById('app-root').innerHTML = html;
        } else {
            console.log(`Fetching HTML for view ${viewName}`);
            fetch(this.viewMetadata.templateUrl)
                .then(response => {
                    console.log(response);
                    return response.text();
                })
                .then(viewHtml => {
                    html = viewHtml;
                    document.getElementById('app-root').innerHTML = html;
                    cb();
                })
                .catch(err => console.error(err));
        }
    }

    this.injectStyleSheet = function() {
        let stylesheet = document.getElementById('dynamic-css');
        if (stylesheet) stylesheet.remove();
        stylesheet = document.createElement('link');
        stylesheet.id = 'dynamic-css';
        stylesheet.rel = 'stylesheet';
        stylesheet.href = this.viewMetadata.stylesUrl;
        document.head.appendChild(stylesheet);
    }

}
