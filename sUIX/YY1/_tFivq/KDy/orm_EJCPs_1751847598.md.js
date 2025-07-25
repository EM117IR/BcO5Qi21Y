'use strict';

module.exports = {
  extends: [
    'eslint:recommended'
  ],
  ignorePatterns: [
    'tools',
    'dist',
    'test/files/*',
    'benchmarks',
    '*.min.js',
    '**/docs/js/native.js',
    '!.*',
    'node_modules',
    '.git',
    'data',
    '.config'
  ],
  overrides: [
    {
      files: [
        '**/*.{ts,tsx}',
        '**/*.md/*.ts',
        '**/*.md/*.typescript'
      ],
      parserOptions: {
        project: './tsconfig.json'
      },
      extends: [
        'plugin:@typescript-eslint/eslint-recommended',
        'plugin:@typescript-eslint/recommended'
      ],
      plugins: [
        '@typescript-eslint'
      ],
      rules: {
        '@typescript-eslint/triple-slash-reference': 'off',
        '@typescript-eslint/no-non-null-assertion': 'off',
        '@typescript-eslint/no-empty-function': 'off',
        'spaced-comment': [
          'error',
          'always',
          {
            block: {
              markers: [
                '!'
              ],
              balanced: true
            },
            markers: [
              '/'
            ]
          }
        ],
        '@typescript-eslint/no-explicit-any': 'off',
        '@typescript-eslint/ban-types': 'off',
        '@typescript-eslint/no-unused-vars': 'off',
        '@typescript-eslint/explicit-module-boundary-types': 'off',
        '@typescript-eslint/prefer-optional-chain': 'error',
        '@typescript-eslint/no-dupe-class-members': 'error',
        '@typescript-eslint/no-redeclare': 'error',
        '@typescript-eslint/space-infix-ops': 'off',
        '@typescript-eslint/no-require-imports': 'off',
        '@typescript-eslint/no-empty-object-type': 'off',
        '@typescript-eslint/no-wrapper-object-types': 'off',
        '@typescript-eslint/no-unused-expressions': 'off',
        '@typescript-eslint/no-unsafe-function-type': 'off'
      }
    },
    {
      files: [
        '**/docs/js/**/*.js'
      ],
      env: {
        node: false,
        browser: true
      }
    }
  ],
  plugins: [
    'mocha-no-only'
    // 'markdown'
  ],
  parserOptions: {
    ecmaVersion: 2022
  },
  env: {
    node: true,
    es6: true,
    es2020: true
  },
  rules: {
    'comma-style': 'error',
    indent: [
      'error',
      2,
      {
        SwitchCase: 1,
        VariableDeclarator: 2
      }
    ],
    'keyword-spacing': 'error',
    'no-whitespace-before-property': 'error',
    'no-buffer-constructor': 'warn',
    'no-console': 'off',
    'no-constant-condition': 'off',
    'no-multi-spaces': 'error',
    'func-call-spacing': 'error',
    'no-trailing-spaces': 'error',
    'no-undef': 'error',
    'no-unneeded-ternary': 'error',
    'no-const-assign': 'error',
    'no-useless-rename': 'error',
    'no-dupe-keys': 'error',
    'space-in-parens': [
      'error',
      'never'
    ],
    'spaced-comment': [
      'error',
      'always',
      {
        block: {
          markers: [
            '!'
          ],
          balanced: true
        }
      }
    ],
    'key-spacing': [
      'error',
      {
        beforeColon: false,
        afterColon: true
      }
    ],
    'comma-spacing': [
      'error',
      {
        before: false,
        after: true
      }
    ],
    'array-bracket-spacing': 1,
    'arrow-spacing': [
      'error',
      {
        before: true,
        after: true
      }
    ],
    'object-curly-spacing': [
      'error',
      'always'
    ],
    'comma-dangle': [
      'error',
      'never'
    ],
    'no-unreachable': 'error',
    quotes: [
      'error',
      'single'
    ],
    'quote-props': [
      'error',
      'as-needed'
    ],
    semi: 'error',
    'no-extra-semi': 'error',
    'semi-spacing': 'error',
    'no-spaced-func': 'error',
    'no-throw-literal': 'error',
    'space-before-blocks': 'error',
    'space-before-function-paren': [
      'error',
      'never'
    ],
    'space-infix-ops': 'error',
    'space-unary-ops': 'error',
    'no-var': 'warn',
    'prefer-const': 'warn',
    strict: [
      'error',
      'global'
    ],
    'no-restricted-globals': [
      'error',
      {
        name: 'context',
        message: 'Don\'t use Mocha\'s global context'
      }
    ],
    'no-prototype-builtins': 'off',
    'mocha-no-only/mocha-no-only': [
      'error'
    ],
    'no-empty': 'off',
    'eol-last': 'warn',
    'no-multiple-empty-lines': ['warn', { max: 2 }]
  }
};
